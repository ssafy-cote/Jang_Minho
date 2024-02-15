public class PG_SkillTree {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        trees:
        for(int i =  0; i < skill_trees.length; i++) {
            // 현재까지 배운 스킬의 인덱스
            int currSkill = -1;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                // 스킬트리에서 현재 배우고자 하는 스킬
                int newSkill = skill.indexOf(skill_trees[i].charAt(j));
                // skill에 없는 스킬트리인경우 스킵
                if (newSkill == -1) continue;
                // 현재까지 배운 스킬의 바로 다음스킬인가?
                if (newSkill == currSkill + 1) currSkill = newSkill;
                // 아니면 다음 스킬트리로 넘어감
                else continue trees;
            }
            answer++;
        }
        return answer;
    }
}
