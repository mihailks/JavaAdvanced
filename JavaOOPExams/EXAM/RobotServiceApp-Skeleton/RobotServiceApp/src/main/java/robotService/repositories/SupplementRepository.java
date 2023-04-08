package robotService.repositories;

import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepository implements Repository {


    private Collection<Supplement> supplements;


    public SupplementRepository() {
        this.supplements = new ArrayList<>();
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public boolean removeSupplement(Supplement supplement) {
        return this.supplements.remove(supplement);
    }

    @Override
    public Supplement findFirst(String type) {
        Supplement supplement = null;
        for (Supplement s : supplements) {
            if (s.getClass().getSimpleName().equals(type)){
                supplement = s;
                break;
            }
        }
        return supplement;

//        return this.supplements.stream().filter(s->s.getClass().getSimpleName().equals(type))
//                .findFirst().orElse(null);
    }
}
