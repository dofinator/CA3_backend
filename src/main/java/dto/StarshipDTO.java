package dto;

public class StarshipDTO {

    private int name;
    private int model;
    private int cost_in_credits;

    public StarshipDTO(int name, int model, int cost_in_credits) {
        this.name = name;
        this.model = model;
        this.cost_in_credits = cost_in_credits;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(int cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

}
