package resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import resources.Secured;
import entites.Role;
import entites.User;
import iservices.IUserService;;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class RoleFilter implements ContainerRequestFilter{

	
	@EJB
	IUserService userService;
	
	@Context
    private ResourceInfo resourceInfo;
	
	@Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Get the resource class which matches with the requested URL
        // Extract the roles declared by it
        Class<?> resourceClass = resourceInfo.getResourceClass();
        List<Role> classRoles = extractRoles(resourceClass);

        // Get the resource method which matches with the requested URL
        // Extract the roles declared by it
        Method resourceMethod = resourceInfo.getResourceMethod();
        List<Role> methodRoles = extractRoles(resourceMethod);

        try {
            checkPermissions(requestContext.getSecurityContext().getUserPrincipal(), classRoles);
            checkPermissions(requestContext.getSecurityContext().getUserPrincipal(), methodRoles);
        } catch (Exception e) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED)
                    .entity("You don't have enough credentials").build());
        }
    }

    private void checkPermissions(Principal userPrincipal, List<Role> roles) throws Exception {

        if (roles == null || roles.isEmpty()) {
            return;
        }
        if (userPrincipal == null) {
            throw new Exception("Not Logged");
        }
        System.out.println("userPrincipal = [" + userPrincipal.getName() + "], roles = [" + roles + "]");
        User searchUser = new User();
    	searchUser.setEmail(userPrincipal.getName());
    	
    	User user = userService.findUser(searchUser);
    	if(roles.contains(user.getRoles()))
    		return;
        throw new Exception("Not Authorized");
    }

    // Extract the roles from the annotated element
    private List<Role> extractRoles(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            return new ArrayList<Role>();
        } else {
            Secured secured = annotatedElement.getAnnotation(Secured.class);
            if (secured == null) {
                return new ArrayList<Role>();
            } else {
                Role[] allowedRoles = secured.value();
                return Arrays.asList(allowedRoles);
            }
        }
    }

}
