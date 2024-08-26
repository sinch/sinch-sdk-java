import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VersionTemplating {

  public static void main(String[] args) throws IOException {
    String versionFile = "client/src/main/com/sinch/sdk/SDK.java";

    Stream<String> lines = Files.lines(Paths.get(versionFile));
    String content = lines.collect(Collectors.joining("\n"));
    lines.close();

    System.out.println(
        content.replaceAll("VERSION = \".*\"", String.format("VERSION = \"%s\"", args[0])));
    System.out.println("");
  }
}
