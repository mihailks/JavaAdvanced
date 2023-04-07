package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BARREL_CAPACITY = 10;

    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        int bulletsInBarrel = this.getBulletsPerBarrel();
        int totalBullets = this.getTotalBullets();

        if (bulletsInBarrel == 0 && totalBullets == 0) {
            setCanFire(false);
            return 0;
        }

        if (bulletsInBarrel > 0) {
            bulletsInBarrel-=5;
        }

        if (bulletsInBarrel == 0) {
            if (totalBullets >= BARREL_CAPACITY) {
                totalBullets -= BARREL_CAPACITY;
                bulletsInBarrel = BARREL_CAPACITY;
            } else {
                bulletsInBarrel = totalBullets;
                totalBullets = 0;
            }
        }
        setBulletsPerBarrel(bulletsInBarrel);
        setTotalBullets(totalBullets);

        return 5;
    }
}
