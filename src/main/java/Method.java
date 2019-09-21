import joptsimple.OptionParser;

public abstract class Method {

    private String[] args;

    public Method() {
        this.args = null;
    }

    public Method(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public OptionParser getPOSTparser() {
        OptionParser parser = new OptionParser();
        parser.nonOptions("Method POST").ofType(String.class);
        parser.accepts("v", "Prints the detail of the response such as protocol, " +
                "status, and headers.");
        parser.accepts("h", "Associates headers to HTTP Request with the " +
                "format 'key:value'").withRequiredArg();
        parser.accepts("d", "Associates an inline data to the body HTTP POST request.")
                .requiredUnless("f")
                .availableUnless("f");
        parser.accepts("f", "Associates the content of a file to the body HTTP post request.")
                .requiredUnless("d")
                .availableUnless("d");
        parser.nonOptions("URL").ofType(String.class);
        return parser;
    }

    public OptionParser getGETparser() {
        OptionParser parser = new OptionParser();
        parser.nonOptions("Method GET").ofType(String.class);
        parser.accepts("v", "Prints the detail of the response such as protocol, " +
                "status, and headers.");
        parser.accepts("h", "Associates headers to HTTP Request with the " +
                "format 'key:value'").withRequiredArg();
        parser.nonOptions("URL").ofType(String.class);
        return parser;
    }
}
