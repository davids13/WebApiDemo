package facade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SampleFacadeTest {

    @InjectMocks
    private SampleFacade facade;

    @Test
    @DisplayName("should match eneity values")
    void shouldMatchValue() {
        var entity = facade.getSample();

        assertEquals("sample", entity.getName());
        assertEquals(1, entity.getNumber());
    }
}