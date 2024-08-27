import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VersionTemplating {

  static final String SDK_FILE_PATH = "client/src/main/com/sinch/sdk/SDK.java";

  public static void main(String[] args) throws IOException {

    String versionValue = args[0];

    Stream<String> lines = Files.lines(Paths.get(SDK_FILE_PATH));
    String content = lines.collect(Collectors.joining("\n"));
    lines.close();

    System.out.println(
        content.replaceAll("VERSION = \".*\"", String.format("VERSION = \"%s\"", versionValue)));
    System.out.println("");
  }
}
