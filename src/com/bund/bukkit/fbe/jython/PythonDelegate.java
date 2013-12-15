package com.bund.bukkit.fbe.jython;

import org.bukkit.Server;
import org.python.util.PythonInterpreter;

public class PythonDelegate
{
	private PythonInterpreter interp;
	private Server server;
	
	public PythonDelegate(final Server server)
	{
		interp = new PythonInterpreter();
		this.server = server;
	}
	
	public void loadScript(final String name)
	{
		interp.set("server", server);
		interp.execfile(name);
	}
}
