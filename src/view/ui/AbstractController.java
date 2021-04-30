package view.ui;

import javafx.fxml.FXML;

import java.util.List;

public abstract class AbstractController {

    private AbstractController parentController;

    @FXML
    protected final void initialize() {
        initThis();
        setThisAsParentController();
    }

    public abstract void initThis();

    public abstract void updateThis();

    protected void updateAllChildren() {
        List<AbstractController> controllers = getChildrenControllers();

        if (controllers != null)
            for (AbstractController controller : controllers) {
                controller.updateAllChildren();
                controller.updateThis();
            }
    }

    public AbstractController getParentController() {
        return parentController;
    }

    public void setParentController(AbstractController parentController) {
        this.parentController = parentController;
    }

    public final void setThisAsParentController() {
        List<AbstractController> controllers = getChildrenControllers();

        if (controllers == null)
            return;

        for (AbstractController childController : controllers) {
            if (childController == null)
                continue;

            childController.setParentController(this);
        }
    }

    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    public GameUIController getRootController() {
        AbstractController actualController = getParentController();

        if (this instanceof GameUIController)
            return (GameUIController) this;

        else if (actualController == null)
            return null;

        else
            return actualController.getRootController();
    }
}
