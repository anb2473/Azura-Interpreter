import Kernel.Azura.AzuraCompiler;

public class Main {
    public static void main(String[] args) {
        AzuraCompiler compiler = new AzuraCompiler();
        compiler.execute("src/TestScripts/test.azu", null);
        System.out.println(compiler.getData());
    }
}
