import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.core.JsonLocation;

public final class Constructed {

  public JsonLocation location;

  public int value;

  Constructed(@JacksonInject final JsonLocation location, @JsonProperty("value") final int value) {
    this.value = value;
    this.location = location;
  }
}
