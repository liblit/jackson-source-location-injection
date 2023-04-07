import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;

class SourceLocationInjector extends InjectableValues {

  private static void trace(final JsonLocation location, final String description) {
    System.out.format("%s: %s location%n", location, description);
  }

  @Override
  public JsonLocation findInjectableValue(
      final Object valueId,
      final DeserializationContext deserializationContext,
      final BeanProperty forProperty,
      final Object beanInstance)
      throws JsonMappingException {

    final var forPropertyType = forProperty.getType();
    if (!forPropertyType.hasRawClass(JsonLocation.class)) {
      throw JsonMappingException.from(
          deserializationContext, "Cannot inject value of type %s.".formatted(forPropertyType));
    }

    final var parser = deserializationContext.getParser();
    trace(parser.getTokenLocation(), "token");
    trace(parser.getCurrentLocation(), "current");
    trace(
        parser.getParsingContext().startLocation(parser.getTokenLocation().contentReference()),
        "context");
    System.out.println();

    return null;
  }
}
