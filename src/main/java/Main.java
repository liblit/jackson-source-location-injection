import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    final var mapper = new ObjectMapper();
    mapper.setInjectableValues(new SourceLocationInjector());

    final var sourceFile = new File("src/main/resources/document.json");
    mapper.readValue(sourceFile, POJO.class);
    mapper.readValue(sourceFile, Constructed.class);
  }
}
