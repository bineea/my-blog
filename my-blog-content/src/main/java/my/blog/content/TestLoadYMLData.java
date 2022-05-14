package my.blog.content;

import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "testLoadData")
public class TestLoadYMLData {

    private String testA;
    private String testB;
    private String testC;

    public String getTestA() {
        return testA;
    }

    public void setTestA(String testA) {
        this.testA = testA;
    }

    public String getTestB() {
        return testB;
    }

    public void setTestB(String testB) {
        this.testB = testB;
    }

    public String getTestC() {
        return testC;
    }

    public void setTestC(String testC) {
        this.testC = testC;
    }

}
