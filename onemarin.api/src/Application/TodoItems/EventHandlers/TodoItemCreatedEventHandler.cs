using onemarin.api.Domain.Events;
using Microsoft.Extensions.Logging;

namespace onemarin.api.Application.TodoItems.EventHandlers;

public class TodoItemCreatedEventHandler : INotificationHandler<TodoItemCreatedEvent>
{
    private readonly ILogger<TodoItemCreatedEventHandler> _logger;

    public TodoItemCreatedEventHandler(ILogger<TodoItemCreatedEventHandler> logger)
    {
        _logger = logger;
    }

    public Task Handle(TodoItemCreatedEvent notification, CancellationToken cancellationToken)
    {
        _logger.LogInformation("onemarin.api Domain Event: {DomainEvent}", notification.GetType().Name);

        return Task.CompletedTask;
    }
}
