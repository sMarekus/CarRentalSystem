using System.Text.Json;
using System.Text.Json.Serialization;

namespace HttpClients.utils;

public class CustomEnumConverter<TEnum> : JsonConverter<TEnum> where TEnum : struct, Enum
{
    public override TEnum Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
    {
        if (reader.TokenType != JsonTokenType.String)
        {
            throw new JsonException();
        }

        string enumString = reader.GetString();
        if (Enum.TryParse<TEnum>(enumString, true, out var result))
        {
            return result;
        }

        throw new JsonException($"Unable to convert '{enumString}' to enum type '{typeof(TEnum)}'.");
    }

    public override void Write(Utf8JsonWriter writer, TEnum value, JsonSerializerOptions options)
    {
        writer.WriteStringValue(value.ToString());
    }
}