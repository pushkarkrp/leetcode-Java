class Leaderboard {
    
    Map<Integer, Integer> scoreById;
    TreeMap<Integer, Integer> countByScore;

    public Leaderboard() {
        scoreById = new HashMap<>();
        countByScore = new TreeMap<>((a,b) -> b-a);
    }
    
    public void addScore(int playerId, int score) {
        if (scoreById.containsKey(playerId)) {
            int oldScore = scoreById.get(playerId);
            scoreById.put(playerId, scoreById.getOrDefault(playerId,0)+score);
            countByScore.put(oldScore, countByScore.getOrDefault(oldScore,0)-1);
            if (countByScore.get(oldScore) == 0) {
                countByScore.remove(oldScore);
            }
            int newScore = oldScore + score;
            countByScore.put(newScore, countByScore.getOrDefault(newScore,0)+1);
        } else {
            scoreById.put(playerId, score);
            countByScore.put(score, countByScore.getOrDefault(score,0)+1);
        }
    }
    
    public int top(int k) {
        int counter = 0;
        int score = 0;
        for (Map.Entry<Integer, Integer> entry : countByScore.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            for (int i = 0; i < value; i++) {
                score += key;
                counter++;
                if ( counter == k) {
                    break;
                }
            }
            if ( counter == k) {
                    break;
            }
        }
        return score;
    }
    
    public void reset(int playerId) {
        int score = scoreById.get(playerId);
        scoreById.remove(playerId);
        countByScore.put(score, countByScore.getOrDefault(score,0)-1);
        if(countByScore.get(score) == 0) countByScore.remove(score);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */