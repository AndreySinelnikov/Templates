public class PropertyReader {
  
    public Properties readPropertiesFromFile (String filePath) throws IOException {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream(filePath));
        return props;
    }
  
    // with Lombok
    @SneakyThrows
    public Properties readPropertiesFromFile (String filePath) {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream(filePath));
        return props;
    }
}
