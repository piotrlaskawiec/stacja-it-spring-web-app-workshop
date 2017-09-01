package it.stacja.springfunapp.purespring;

public class SampleBean3 {
    private final SampleBean1 sampleBean1;
    private final SampleBean2 sampleBean2;

    public SampleBean3(SampleBean1 sampleBean1, SampleBean2 sampleBean2) {
        this.sampleBean1 = sampleBean1;
        this.sampleBean2 = sampleBean2;
    }

    public void businessLogic() {
        System.out.println("businessLogic from SampleBean3");

        this.sampleBean1.businessLogic();
        this.sampleBean2.businessLogic();
    }


    public SampleBean1 getSampleBean1() {
        return sampleBean1;
    }

    public SampleBean2 getSampleBean2() {
        return sampleBean2;
    }
}
