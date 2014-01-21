import com.urbancode.air.CommandHelper;

final def inputPropsFile = new File(args[0])
final def outputPropsFile = new File(args[1])

final def props = new Properties()
try {
    props.load(new FileInputStream(inputPropsFile))
}
catch (IOException e) {
    throw new RuntimeException(e)
}

final def cwd = new File('.');
final def cmdHelper = new CommandHelper(cwd);



//--------------------------------------------------------------------------------------------------
def getAbsPath(def file) {
    def tempFile = null;
    if (file != null && file != "") {
        File temporaryFile = new File(file);
        tempFile = temporaryFile.getAbsolutePath();
    }
    return tempFile;
}
//path properties
def daticalDBCmd = getAbsPath(props['daticalDBCmd']);
def daticalDBDriversDir = getAbsPath(props['daticalDBDriversDir']);
def daticalDBAction = "deploy";
def daticalDBServer = props['daticalDBServer'];
def daticalDBRollback = props['daticalDBRollback']

println "daticalDBAction: " + daticalDBAction;
println "daticalDBRollback: " + daticalDBRollback;
if (daticalDBRollback == "false") {
    daticalDBAction = "deploy";
} else {
	daticalDBAction = "deploy-autoRollback";
}
println "daticalDBAction: " + daticalDBAction;


def cmdArgs = [daticalDBCmd, '-drivers', daticalDBDriversDir, daticalDBAction, daticalDBServer];
//println "cmdArgs: " + cmdArgs;

int exitCode = cmdHelper.runCommand("Executing Datical DB", cmdArgs);
//println "exitCode: " + exitCode;

System.exit(exitCode);