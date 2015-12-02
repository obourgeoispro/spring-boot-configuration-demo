package com.example;

import org.junit.*;
import org.springframework.boot.test.OutputCapture;

public class ConfigurationApplicationTests {

    public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";
    private String profiles;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Before
    public void before() {
        this.profiles = System.getProperty(SPRING_PROFILES_ACTIVE);
    }

    @After
    public void after() {
        if (this.profiles != null) {
            System.setProperty(SPRING_PROFILES_ACTIVE, this.profiles);
        } else {
            System.clearProperty(SPRING_PROFILES_ACTIVE);
        }
    }
	@Test
	public void testDefaultProfile() throws Exception {
        ConfigurationApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        Assert.assertTrue("Unexpected output: " + output, output.contains("http://localhost:8080/api"));
    }

    @Test
    public void testDevProfile() throws Exception {
        System.setProperty("spring.profiles.active", "development");
        ConfigurationApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        Assert.assertTrue("Unexpected output: " + output, output.contains("http://dev.apiserver.internal"));
    }
}
