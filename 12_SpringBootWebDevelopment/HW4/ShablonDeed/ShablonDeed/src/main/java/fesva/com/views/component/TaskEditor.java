package fesva.com.views.component;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import fesva.com.models.Priority;
import fesva.com.models.Task;
import fesva.com.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;


@SpringComponent
@UIScope
public class TaskEditor extends Dialog implements KeyNotifier {
	private final TaskRepo taskRepo;

	private Task task;

	private TextField name = new TextField("Заголовок");
	private TextArea details = new TextArea("Описание");
	private Select<Priority> priority = new Select<>(Priority.values());

	private VerticalLayout layout = new VerticalLayout();
	private Button save = new Button("Сохранить", VaadinIcon.CHECK.create());
	private Button remove = new Button("Удалить", VaadinIcon.TRASH.create());
	private Button cancel = new Button("Отмена");
	private HorizontalLayout buttons = new HorizontalLayout(save, remove, cancel);

	private Label creationTime = new Label();
	private Label lastUpdateTime = new Label();

	private Binder<Task> binder = new Binder<>(Task.class);

	public TaskRepo getTaskRepo() {
		return taskRepo;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public TextArea getDetails() {
		return details;
	}

	public void setDetails(TextArea details) {
		this.details = details;
	}

	public Select<Priority> getPriority() {
		return priority;
	}

	public void setPriority(Select<Priority> priority) {
		this.priority = priority;
	}

	public VerticalLayout getLayout() {
		return layout;
	}

	public void setLayout(VerticalLayout layout) {
		this.layout = layout;
	}

	public Button getSave() {
		return save;
	}

	public void setSave(Button save) {
		this.save = save;
	}

	public Button getRemove() {
		return remove;
	}

	public void setRemove(Button remove) {
		this.remove = remove;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public HorizontalLayout getButtons() {
		return buttons;
	}

	public void setButtons(HorizontalLayout buttons) {
		this.buttons = buttons;
	}

	public Label getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Label creationTime) {
		this.creationTime = creationTime;
	}

	public Label getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Label lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Binder<Task> getBinder() {
		return binder;
	}

	public void setBinder(Binder<Task> binder) {
		this.binder = binder;
	}

	public ChangeHandler getChangeHandler() {
		return changeHandler;
	}

	public void setChangeHandler(ChangeHandler changeHandler) {
		this.changeHandler = changeHandler;
	}

	@Setter
	public ChangeHandler changeHandler;

	public void setChangeHandler(Object changeHandler) {
		this.changeHandler = (ChangeHandler) changeHandler;
	}

	public interface ChangeHandler {
		void onChange();
	}

	@Autowired
	public TaskEditor(TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
		priority.setLabel("Приоритет");

		name.setWidthFull();
		details.setWidthFull();
		priority.setWidthFull();

		binder.bindInstanceFields(this);
		layout.setSpacing(true);

		save.getElement().getThemeList().add("primary");
		remove.getElement().getThemeList().add("error");
		layout.add(name, details, priority, creationTime, lastUpdateTime, buttons);
		add(layout);

		addKeyPressListener(Key.ENTER, e -> save());

		save.addClickListener(e -> save());
		remove.addClickListener(e -> remove());
		cancel.addClickListener(e -> changeHandler.onChange());
	}

	private void save() {
		taskRepo.save(task);
		changeHandler.onChange();
	}

	private void remove() {
		taskRepo.delete(task);
		changeHandler.onChange();
	}

	public void editTask(Task task) {
		if (task == null) {
			close();
			return;
		}

		if (task.getId() != null) {
			remove.setVisible(true);
			this.task = taskRepo.findById(task.getId()).orElse(task);
		} else {
			this.task = task;
			remove.setVisible(false);
		}

		binder.setBean(this.task);

		if (task.getCreationTime() != null) {
			creationTime.setText("Создано: " + task.getCreationTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
			creationTime.setVisible(true);
		} else {
			creationTime.setText("");
			creationTime.setVisible(false);
		}
		if (task.getLastUpdateTime() != null) {
			lastUpdateTime.setText("Изменено: " + task.getLastUpdateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
			lastUpdateTime.setVisible(true);
		} else {
			lastUpdateTime.setText("");
			lastUpdateTime.setVisible(false);
		}

		if (priority.isEmpty())
			priority.setValue(Priority.NOT_URGENT);

		open();
		name.focus();
	}
}
