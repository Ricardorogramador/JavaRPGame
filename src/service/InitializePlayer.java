package service;

import model.Player;
    import model.Race;
    import interfaces.*;

    import java.util.Scanner;

    public class InitializePlayer implements InitializePlayerInterface {
        Scanner input = new Scanner(System.in);
        public void createPlayer(Player player) {
            System.out.println("--Character creation--");
            System.out.println("Select your race");
            System.out.println("1. Human");
            System.out.println("More races in the future");
            int option = input.nextInt();
            switch (option){
                case 1:
                    player.setRace(Race.Human);
                    break;
            }
            System.out.println("Introduce your name");
            String name = input.next();
            player.setName(name);
            System.out.println("Now distribute your stats");
            player.setStrength(1);
            player.setWisdom(1);
            player.setLucky(1);
            player.setIntelligence(1);
            StatsDistributor.distributeStats(player, 10, input);
            System.out.println("Good luck in your journey");
        }

        @Override
        public void initializePlayer(Player player) {
            player.setAlive(true);
            double hp;
            hp = 100 + (player.getStrength() * 5);
            player.setHp(hp);
            player.setMaximumHP(hp);
            double attack = 10 + (player.getStrength() * 1.5);
            player.setAttack(attack);
            double defense = 5 + (player.getDefense() * 1.2);
            player.setDefense(defense);
        }
    }
