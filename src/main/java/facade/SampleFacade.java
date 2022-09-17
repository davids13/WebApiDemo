package facade;

import entity.SampleEntity;

import javax.ejb.Singleton;

@Singleton
public class SampleFacade {

    public SampleEntity getSample() {
        return new SampleEntity();
    }
}
