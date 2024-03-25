using onemarin.api.Infrastructure.Identity;

namespace onemarin.api.Web.Endpoints;

public class Users : EndpointGroupBase
{
    public override void Map(WebApplication app)
    {
        app.MapGroup(this)
            .MapIdentityApi<ApplicationUser>();
    }
}
