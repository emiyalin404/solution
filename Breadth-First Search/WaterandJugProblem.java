public class WaterandJugProblem {
    public static void main(String[] args) {
        WaterandJugProblem solution = new WaterandJugProblem();
        int jug1Capacity = 3;
        int jug2Capacity = 2;
        int targetCapacity = 4;
        boolean ans = solution.input(jug1Capacity, jug2Capacity, targetCapacity);
        System.out.println(ans);
    }

    public boolean input(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }
        int lastMod = jug1Capacity;
        int mod = jug2Capacity % jug1Capacity;
        while (mod != 0) {
            int temp = lastMod;
            System.out.println(mod);
            lastMod = mod;
            mod = temp % mod;
        }
        if (targetCapacity % lastMod == 0) {
            return true;
        }
        return false;
    }
}
