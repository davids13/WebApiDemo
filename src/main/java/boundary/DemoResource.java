package boundary;

import facade.SampleFacade;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1")
@ApplicationScoped
public class DemoResource {

    @Inject
    private SampleFacade facade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSample() {
        var entity = facade.getSample();

        return Response.ok().entity(entity).build();
    }
}
