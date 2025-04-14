package groovydemo;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class services

{
	// ---( internal utility methods )---

	final static services _instance = new services();

	static services _newInstance() { return new services(); }

	static services _cast(Object o) { return (services)o; }

	// ---( server methods )---




	public static final void execGroovyScript (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(execGroovyScript)>> ---
		// @sigtype java 3.5
		// Input XML string
		String xmlInput = """
		        <books>
		            <book title="1984" author="George Orwell"/>
		            <book title="Brave New World" author="Aldous Huxley"/>
		        </books>
		        """;
		
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current absolute path is: " + s);
		  
		// Load external script
		
		File scriptFile = new File(s +"/packages/GroovyDemo/scripts/modifyXml.groovy"); // path to your script
		String scriptContent = null;
		try {
			scriptContent = Files.readString(scriptFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Prepare the binding
		Binding binding = new Binding();
		binding.setVariable("inputXml", xmlInput);
		
		// Execute the Groovy script
		GroovyShell shell = new GroovyShell(binding);
		Object result = shell.evaluate(scriptContent);
		
		System.out.println("Modified XML:\n" + result);
		// --- <<IS-END>> ---

                
	}
}

