package service.battle;

import DBConnection.SkillDAO;
import model.Monster;
import model.Player;
import model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillsLogic {
    SkillDAO skillDAO = new SkillDAO();
    public void useSkill(Player player, int skillID, Monster monster){

        List<Skill> skills = skillDAO.getSkills(player.getId());

        Skill selectedSKill = null;
        for (Skill skill : skills){
            if (skill.getId_skill() == skillID){
                selectedSKill = skill;
                break;
            }
        }
        if (selectedSKill == null){
            System.out.println("You don't have this skill unlocked");
            return;
        }
        if (player.getMana() < selectedSKill.getManaCost()){
            System.out.println("You don't have enough mana to use: " + selectedSKill.getName());
            return;
        }
        player.setMana(player.getMana() - selectedSKill.getManaCost());
        double nuevoHP = monster.getHp() - selectedSKill.getMagicDamage();
        monster.setHp(nuevoHP);

        System.out.println(player.getName() + " use " + selectedSKill.getName() +
                " did " + selectedSKill.getMagicDamage() + " of damage. " + " The enemy have now " +
                monster.getHp() + " HP");
    }

    public void showSKills(Player player, Monster monster) {
        List<Skill> skills = skillDAO.getSkills(player.getId());

        if (skills.isEmpty()) {
            System.out.println("You don't have any skill unlocked.");
            return;
        }


        System.out.println("Your skills:");
        for (Skill skill : skills) {
            System.out.println("ID: " + skill.getId_skill() +
                    " - " + skill.getName() +
                    " (Damage: " + skill.getMagicDamage() +
                    ", Maná: " + skill.getManaCost() + ")");
        }


        System.out.print("Select the ID of the skill you want to use: ");
        Scanner scanner = new Scanner(System.in);
        int skillId = scanner.nextInt();

        useSkill(player, skillId, monster);
    }

}
