package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import java.util.Objects;

/**
 * @author NikitaGayduk
 * @date 25.04.2019
 */
public class WorkType extends Entity {
    private String workName;
    private Profession requiredProfession;

    public WorkType() {
    }

    public WorkType(int id, String workName, Profession requiredProfession) {
        super(id);
        this.workName = workName;
        this.requiredProfession = requiredProfession;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Profession getRequiredProfession() {
        return requiredProfession;
    }

    public void setRequiredProfession(Profession requiredProfession) {
        this.requiredProfession = requiredProfession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorkType workType = (WorkType) o;
        return Objects.equals(workName, workType.workName) &&
                requiredProfession == workType.requiredProfession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workName, requiredProfession);
    }

    @Override
    public String toString() {
        return "WorkType{" +
                "workName='" + workName + '\'' +
                ", requiredProfession=" + requiredProfession +
                "} " + super.toString();
    }
}
