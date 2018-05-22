/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hss;

import java.util.Vector;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Altysh
 */
@Path("/")
public class GenericResource {
@Context  ServletContext context;
    Vector<NewClass> list;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of hss.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public NewClass getJson(@PathParam("id") int id) {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       list= (Vector<NewClass>) context.getAttribute("list");
       if(list!=null)
       {
           for(NewClass classs:list)
               if(classs.i==id)
                   return classs;
       }
           System.out.println("hham");        
       return new NewClass();
    }
       @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public NewClass getJsonXml(@PathParam("id") int id) {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
        System.out.println("hham");     
       list= (Vector<NewClass>) context.getAttribute("list");
       if(list!=null)
       {
           for(NewClass classs:list)
               if(classs.i==id)
                   return classs;
       }
                   
       return new NewClass();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void putJson(@FormParam("id") int  id,
                                @FormParam("name") String name,
                                @FormParam("salary") double salary)
    {
        System.out.println(id +" "+name+" "+ salary); 
        
       
     list= (Vector<NewClass>) context.getAttribute("list");
     if(list!=null)
     {NewClass cla = new NewClass();
     cla.setI(id);
     cla.setS(name);
     cla.setD(salary);
         list.add(cla);
     }else{
         list= new Vector<>();
        NewClass cla = new NewClass();
     cla.setI(id);
     cla.setS(name);
     cla.setD(salary);
         list.add(cla); 
         context.setAttribute("list", list);
     }
    }
    @POST
    @Path("post")
    @Consumes("application/json")
    public void putJson(NewClass n)
    {
        System.out.println("put josn");
        list= (Vector<NewClass>) context.getAttribute("list");
     if(list!=null)
     {
        list.add(n); 
     }else
     {
         list= new Vector<>();
         list.add(n); 
         context.setAttribute("list", list);

     }
    }
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(NewClass n)
    {
        System.out.println("put josn");
        list= (Vector<NewClass>) context.getAttribute("list");
     if(list!=null)
     {
        list.add(n); 
     }else
     {
         list= new Vector<>();
         list.add(n); 
         context.setAttribute("list", list);

     }
    }
    
      @PUT
    @Path("update")
    @Consumes("application/json")
    public void update(NewClass n)
    {
        //System.out.println("put josn");
       
        list= (Vector<NewClass>) context.getAttribute("list");
     if(list!=null)
     {
         for(NewClass item:list)
         {
             if(item.getI()==n.getI())
             {System.out.println("not null");
                 item.setD(n.getD());
             }
         }
       // list.add(n); 
     }else
     {
         
         list= new Vector<>();
         list.add(n); 
         context.setAttribute("list", list);

     }
    }
     @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_XML)
    public void updateXml(NewClass n)
    {
        //System.out.println("put josn");
       
        list= (Vector<NewClass>) context.getAttribute("list");
     if(list!=null)
     {
         for(NewClass item:list)
         {
             if(item.getI()==n.getI())
             {System.out.println("not null");
                 item.setD(n.getD());
             }
         }
       // list.add(n); 
     }else
     {
         
         list= new Vector<>();
         list.add(n); 
         context.setAttribute("list", list);

     }
    }
   
       @DELETE
    @Path("delete")
    @Consumes("application/json")
    public void delete(NewClass n)
    {
        //System.out.println("put josn");
       
        list= (Vector<NewClass>) context.getAttribute("list");
     if(list!=null)
     {
         for(NewClass item:list)
         {
             if(item.getI()==n.getI())
             {
                 list.remove(item);
             }
         }
       // list.add(n); 
     }else
     {
         
         list= new Vector<>();
         //list.add(n); 
         context.setAttribute("list", list);

     }
    }
      @DELETE
    @Path("delete")
    @Consumes(MediaType.APPLICATION_XML)
    public void deleteXml(NewClass n)
    {
        //System.out.println("put josn");
       
        list= (Vector<NewClass>) context.getAttribute("list");
     if(list!=null)
     {
         for(NewClass item:list)
         {
             if(item.getI()==n.getI())
             {
                 list.remove(item);
             }
         }
       // list.add(n); 
     }else
     {
         
         list= new Vector<>();
         //list.add(n); 
         context.setAttribute("list", list);

     }
    }
   
}
