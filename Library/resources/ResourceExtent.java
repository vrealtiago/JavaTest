/*
 * Created on 02-Feb-2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package resources;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class ResourceExtent {
	private static Map resources = new Hashtable();
	private static int idCounter = 0;
	public static ResourceExtent INSTANCE = new ResourceExtent();
	
	private ResourceExtent() {
		// Initialise and register library resources
		createResource(new Book(getNextId(), "Lord of the Rings", "J.R.Tolkien"));
		createResource(new Book(getNextId(),"2001 Space Odessey", "Arthur C Clarke"));
		createResource(new Book(getNextId(),"How to win at bingo", "Two fat ladies"));
		createResource(new Book(getNextId(),"The Cold. Don't let it kill you.", "J.R.Hartley"));
		createResource(new Game(getNextId(), "Halo", "X-Box"));
		createResource(new Game(getNextId(), "Midtown madness", "PS2"));
	}
	public void createResource(Resource resource) {
		resources.put(resource.getId(), resource);
	}

	public Resource findByPrimaryKey(String id) {
		return (Resource)resources.get(id);
	}

	public Collection getResources() {
		return resources.values();
	}

	public String getNextId() {
		return "R" + (idCounter++);
	}
}
