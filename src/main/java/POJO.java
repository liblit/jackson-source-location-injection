import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonLocation;

public final class POJO {

  @JacksonInject public JsonLocation location;

  @JsonProperty("value") public int value;
}
