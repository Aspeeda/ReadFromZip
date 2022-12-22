package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import tests.model.ModelUser;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestJsonReading {

    @Test
    void jsonReadModel() throws Exception {
        ObjectMapper mapper = new ObjectMapper ();
        File file = new File("src/test/resources/info.json");
        ModelUser.User user = mapper.readValue(file, ModelUser.User.class);

        assertThat(user.id).isEqualTo(1);
        assertThat(user.name).isEqualTo("Leanne Graham");
        assertThat(user.username).isEqualTo("Bret");
        assertThat(user.address.street).isEqualTo("Kulas Light");
        assertThat(user.address.suite).isEqualTo("Apt. 556");
        assertThat(user.address.city).isEqualTo("Gwenborough");
        assertThat(user.cars.get(0).name).isEqualTo("Ford");
        assertThat(user.cars.get(0).models.get(0)).isEqualTo("Fiesta");
        assertThat(user.cars.get(0).models.get(1)).isEqualTo("Focus");
        assertThat(user.cars.get(0).models.get(2)).isEqualTo("Mustang");
        assertThat(user.cars.get(1).name).isEqualTo("BMW");
        assertThat(user.cars.get(1).models.get(0)).isEqualTo("320");
        assertThat(user.cars.get(1).models.get(1)).isEqualTo("X3");
        assertThat(user.cars.get(1).models.get(2)).isEqualTo("X5");
        assertThat(user.cars.get(2).name).isEqualTo("Fiat");
        assertThat(user.cars.get(2).models.get(0)).isEqualTo("500");
        assertThat(user.cars.get(2).models.get(1)).isEqualTo("Panda");
    }
}
