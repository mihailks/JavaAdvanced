package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BARREL_CAPACITY = 10;
    //private static final int TOTAL_BULLETS = 100;


    public Pistol(String name) {
        super(name, 10, 100);
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
            bulletsInBarrel--;
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

        return 1;
    }
}

//        if (bulletsInBarrel == 0) {
//                totalBullets -= BARREL_CAPACITY;
//                bulletsInBarrel = BARREL_CAPACITY;
//                }
