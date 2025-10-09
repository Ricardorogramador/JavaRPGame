package service.hub;

import DBConnection.SkillDAO;
import model.Player;
import model.Skill;

import java.util.List;
import java.util.Scanner;

public class ShopService {
    SkillDAO skillDAO = new SkillDAO();
    Scanner input = new Scanner(System.in);
    public void purchaseSkill(Player player, int selectedSkillId){
        List<Skill> skills = skillDAO.getAllSkills();
        Skill selectedSkill = null;
        for (Skill skill : skills){
            if (skill.getId_skill() == selectedSkillId){
                selectedSkill = skill;
                break;
            }
        }
        if (selectedSkill == null){
            System.out.println("You selected a invalid option");
            return;
        }
        if (player.getGold() < selectedSkill.getPrice()){
            System.out.println("You don't have enough money to buy " + selectedSkill.getName());
            return;
        }
        player.setGold(player.getGold() - selectedSkill.getPrice());
        skillDAO.createSkillRelation(player, selectedSkill);
    }

    public void showSkillInShop(Player player){
        List<Skill> skills = skillDAO.getAllSkills();
        for (Skill skill : skills){
            System.out.println("ID: " + skill.getId_skill() + " Name: " + skill.getName() + " Damage: " + skill.getMagicDamage() +
                    " Mana cost: " + skill.getManaCost() + " Description: " + skill.getDescription() + " Price: " + skill.getPrice());
            System.out.println("----------");
        }
        System.out.println("Select the ID of the skill you want to purchase.");
        int idOption = input.nextInt();
        purchaseSkill(player,idOption);
    }

}
