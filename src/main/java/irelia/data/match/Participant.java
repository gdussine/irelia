package irelia.data.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant {
    private int allInPings; // Yellow crossed swords.
    private int assistMePings; // Green flag.
    private int assists; // Number of assists.
    private int baronKills; // Number of baron kills.
    private int bountyLevel; // Current bounty level of the participant.
    private int champExperience; // Champion experience gained.
    private int champLevel; // Champion level.
    private int championId; // Champion ID.
    private String championName; // Name of the champion.
    private int commandPings; // Blue generic ping (ALT+click).
    private int championTransform; // Utilized for Kayn's transformations.
    private int consumablesPurchased; // Number of consumables purchased.
    private Challenges challenges; // Challenges related to the participant.
    private int damageDealtToBuildings; // Damage dealt to buildings.
    private int damageDealtToObjectives; // Damage dealt to objectives.
    private int damageDealtToTurrets; // Damage dealt to turrets.
    private int damageSelfMitigated; // Damage mitigated by the participant.
    private int deaths; // Number of deaths.
    private int detectorWardsPlaced; // Number of detector wards placed.
    private int doubleKills; // Number of double kills.
    private int dragonKills; // Number of dragon kills.
    private boolean eligibleForProgression; // Indicates eligibility for progression.
    private int enemyMissingPings; // Yellow questionmark.
    private int enemyVisionPings; // Red eyeball.
    private boolean firstBloodAssist; // Indicates if the participant assisted in first blood.
    private boolean firstBloodKill; // Indicates if the participant scored first blood.
    private boolean firstTowerAssist; // Indicates if the participant assisted in first tower kill.
    private boolean firstTowerKill; // Indicates if the participant scored first tower kill.
    private boolean gameEndedInEarlySurrender; // Indicates if the game ended in early surrender.
    private boolean gameEndedInSurrender; // Indicates if the game ended in surrender.
    private int holdPings; // Number of hold pings.
    private int getBackPings; // Yellow circle with horizontal line.
    private int goldEarned; // Amount of gold earned.
    private int goldSpent; // Amount of gold spent.
    private String individualPosition; // Best guess for position played by the participant.
    private int inhibitorKills; // Number of inhibitor kills.
    private int inhibitorTakedowns; // Number of inhibitor takedowns.
    private int inhibitorsLost; // Number of inhibitors lost.
    private int item0; // Item slot 0.
    private int item1; // Item slot 1.
    private int item2; // Item slot 2.
    private int item3; // Item slot 3.
    private int item4; // Item slot 4.
    private int item5; // Item slot 5.
    private int item6; // Item slot 6.
    private int itemsPurchased; // Number of items purchased.
    private int killingSprees; // Number of killing sprees.
    private int kills; // Number of kills.
    private String lane; // Lane played by the participant.
    private int largestCriticalStrike; // Largest critical strike damage dealt.
    private int largestKillingSpree; // Largest killing spree.
    private int largestMultiKill; // Largest multi-kill achieved.
    private int longestTimeSpentLiving; // Longest time spent living.
    private int magicDamageDealt; // Magic damage dealt.
    private int magicDamageDealtToChampions; // Magic damage dealt to champions.
    private int magicDamageTaken; // Magic damage taken.
    private Missions missions; // Missions related to the participant.
    private int neutralMinionsKilled; // Number of neutral minions killed.
    private int needVisionPings; // Green ward.
    private int nexusKills; // Number of nexus kills.
    private int nexusTakedowns; // Number of nexus takedowns.
    private int nexusLost; // Number of nexuses lost.
    private int objectivesStolen; // Number of objectives stolen.
    private int objectivesStolenAssists; // Number of assists for objectives stolen.
    private int onMyWayPings; // Blue arrow pointing at ground.
    private int participantId; // Unique identifier for the participant.
    private int playerScore0; // Player score for score 0.
    private int playerScore1; // Player score for score 1.
    private int playerScore2; // Player score for score 2.
    private int playerScore3; // Player score for score 3.
    private int playerScore4; // Player score for score 4.
    private int playerScore5; // Player score for score 5.
    private int playerScore6; // Player score for score 6.
    private int playerScore7; // Player score for score 7.
    private int playerScore8; // Player score for score 8.
    private int playerScore9; // Player score for score 9.
    private int playerScore10; // Player score for score 10.
    private int playerScore11; // Player score for score 11.
    private int pentaKills; // Number of pentakills.
    private Perks perks; // Perks related to the participant.
    private int physicalDamageDealt; // Physical damage dealt.
    private int physicalDamageDealtToChampions; // Physical damage dealt to champions.
    private int physicalDamageTaken; // Physical damage taken.
    private int placement; // Placement of the participant.
    private int playerAugment1; // Player augment 1.
    private int playerAugment2; // Player augment 2.
    private int playerAugment3; // Player augment 3.
    private int playerAugment4; // Player augment 4.
    private int playerSubteamId; // Player subteam ID.
    private int pushPings; // Green minion.
    private int profileIcon; // Profile icon ID.
    private String puuid; // Player's unique ID.
    private int quadraKills; // Number of quadra kills.
    private String riotIdGameName; // Riot ID game name.
    private String riotIdName; // Riot ID name.
    private String riotIdTagline; // Riot ID tagline.
    private String role; // Role played by the participant.
    private int sightWardsBoughtInGame; // Number of sight wards bought in the game.
    private int spell1Casts; // Number of casts for spell 1.
    private int spell2Casts; // Number of casts for spell 2.
    private int spell3Casts; // Number of casts for spell 3.
    private int spell4Casts; // Number of casts for spell 4.
    private int subteamPlacement; // Subteam placement of the participant.
    private int summoner1Casts; // Number of casts for summoner spell 1.
    private int summoner1Id; // ID for summoner spell 1.
    private int summoner2Casts; // Number of casts for summoner spell 2.
    private int summoner2Id; // ID for summoner spell 2.
    private String summonerId; // Summoner ID.
    private int summonerLevel; // Summoner level.
    private String summonerName; // Summoner name.
    private boolean teamEarlySurrendered; // Indicates if the team surrendered early.
    private int teamId; // Team ID.
    private String teamPosition; // Best guess for position played by the team.
    private int timeCCingOthers; // Total time CCing other champions.
    private int timePlayed; // Total time played.
    private int totalAllyJungleMinionsKilled; // Total ally jungle minions killed.
    private int totalDamageDealt; // Total damage dealt.
    private int totalDamageDealtToChampions; // Total damage dealt to champions.
    private int totalDamageShieldedOnTeammates; // Total damage shielded on teammates.
    private int totalDamageTaken; // Total damage taken.
    private int totalEnemyJungleMinionsKilled; // Total enemy jungle minions killed.
    private int totalHeal; // Total healing done.
    private int totalHealsOnTeammates; // Total heals applied to teammates.
    private int totalMinionsKilled; // Total minions killed.
    private int totalTimeCCDealt; // Total time CC dealt.
    private int totalTimeSpentDead; // Total time spent dead.
    private int totalUnitsHealed; // Total units healed.
    private int tripleKills; // Number of triple kills.
    private int trueDamageDealt; // True damage dealt.
    private int trueDamageDealtToChampions; // True damage dealt to champions.
    private int trueDamageTaken; // True damage taken.
    private int turretKills; // Number of turret kills.
    private int turretTakedowns; // Number of turret takedowns.
    private int turretsLost; // Number of turrets lost.
    private int unrealKills; // Number of unreal kills.
    private int visionScore; // Vision score.
    private int visionClearedPings; // Number of vision cleared pings.
    private int visionWardsBoughtInGame; // Number of vision wards bought in the game.
    private int wardsKilled; // Number of wards killed.
    private int wardsPlaced; // Number of wards placed.
    private boolean win; // Indicates if the participant won the game.

    private int basicPings;
    private int dangerPings;

    

    public int getAllInPings() {
        return allInPings;
    }

    public void setAllInPings(int allInPings) {
        this.allInPings = allInPings;
    }

    public int getAssistMePings() {
        return assistMePings;
    }

    public void setAssistMePings(int assistMePings) {
        this.assistMePings = assistMePings;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getBaronKills() {
        return baronKills;
    }

    public void setBaronKills(int baronKills) {
        this.baronKills = baronKills;
    }

    public int getBountyLevel() {
        return bountyLevel;
    }

    public void setBountyLevel(int bountyLevel) {
        this.bountyLevel = bountyLevel;
    }

    public int getChampExperience() {
        return champExperience;
    }

    public void setChampExperience(int champExperience) {
        this.champExperience = champExperience;
    }

    public int getChampLevel() {
        return champLevel;
    }

    public void setChampLevel(int champLevel) {
        this.champLevel = champLevel;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public int getCommandPings() {
        return commandPings;
    }

    public void setCommandPings(int commandPings) {
        this.commandPings = commandPings;
    }

    public int getChampionTransform() {
        return championTransform;
    }

    public void setChampionTransform(int championTransform) {
        this.championTransform = championTransform;
    }

    public int getConsumablesPurchased() {
        return consumablesPurchased;
    }

    public void setConsumablesPurchased(int consumablesPurchased) {
        this.consumablesPurchased = consumablesPurchased;
    }

    public Challenges getChallenges() {
        return challenges;
    }

    public void setChallenges(Challenges challenges) {
        this.challenges = challenges;
    }

    public int getDamageDealtToBuildings() {
        return damageDealtToBuildings;
    }

    public void setDamageDealtToBuildings(int damageDealtToBuildings) {
        this.damageDealtToBuildings = damageDealtToBuildings;
    }

    public int getDamageDealtToObjectives() {
        return damageDealtToObjectives;
    }

    public void setDamageDealtToObjectives(int damageDealtToObjectives) {
        this.damageDealtToObjectives = damageDealtToObjectives;
    }

    public int getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }

    public void setDamageDealtToTurrets(int damageDealtToTurrets) {
        this.damageDealtToTurrets = damageDealtToTurrets;
    }

    public int getDamageSelfMitigated() {
        return damageSelfMitigated;
    }

    public void setDamageSelfMitigated(int damageSelfMitigated) {
        this.damageSelfMitigated = damageSelfMitigated;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getDetectorWardsPlaced() {
        return detectorWardsPlaced;
    }

    public void setDetectorWardsPlaced(int detectorWardsPlaced) {
        this.detectorWardsPlaced = detectorWardsPlaced;
    }

    public int getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(int doubleKills) {
        this.doubleKills = doubleKills;
    }

    public int getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills(int dragonKills) {
        this.dragonKills = dragonKills;
    }

    public boolean isEligibleForProgression() {
        return eligibleForProgression;
    }

    public void setEligibleForProgression(boolean eligibleForProgression) {
        this.eligibleForProgression = eligibleForProgression;
    }

    public int getEnemyMissingPings() {
        return enemyMissingPings;
    }

    public void setEnemyMissingPings(int enemyMissingPings) {
        this.enemyMissingPings = enemyMissingPings;
    }

    public int getEnemyVisionPings() {
        return enemyVisionPings;
    }

    public void setEnemyVisionPings(int enemyVisionPings) {
        this.enemyVisionPings = enemyVisionPings;
    }

    public boolean isFirstBloodAssist() {
        return firstBloodAssist;
    }

    public void setFirstBloodAssist(boolean firstBloodAssist) {
        this.firstBloodAssist = firstBloodAssist;
    }

    public boolean isFirstBloodKill() {
        return firstBloodKill;
    }

    public void setFirstBloodKill(boolean firstBloodKill) {
        this.firstBloodKill = firstBloodKill;
    }

    public boolean isFirstTowerAssist() {
        return firstTowerAssist;
    }

    public void setFirstTowerAssist(boolean firstTowerAssist) {
        this.firstTowerAssist = firstTowerAssist;
    }

    public boolean isFirstTowerKill() {
        return firstTowerKill;
    }

    public void setFirstTowerKill(boolean firstTowerKill) {
        this.firstTowerKill = firstTowerKill;
    }

    public boolean isGameEndedInEarlySurrender() {
        return gameEndedInEarlySurrender;
    }

    public void setGameEndedInEarlySurrender(boolean gameEndedInEarlySurrender) {
        this.gameEndedInEarlySurrender = gameEndedInEarlySurrender;
    }

    public boolean isGameEndedInSurrender() {
        return gameEndedInSurrender;
    }

    public void setGameEndedInSurrender(boolean gameEndedInSurrender) {
        this.gameEndedInSurrender = gameEndedInSurrender;
    }

    public int getHoldPings() {
        return holdPings;
    }

    public void setHoldPings(int holdPings) {
        this.holdPings = holdPings;
    }

    public int getGetBackPings() {
        return getBackPings;
    }

    public void setGetBackPings(int getBackPings) {
        this.getBackPings = getBackPings;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(int goldSpent) {
        this.goldSpent = goldSpent;
    }

    public String getIndividualPosition() {
        return individualPosition;
    }

    public void setIndividualPosition(String individualPosition) {
        this.individualPosition = individualPosition;
    }

    public int getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(int inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public int getInhibitorTakedowns() {
        return inhibitorTakedowns;
    }

    public void setInhibitorTakedowns(int inhibitorTakedowns) {
        this.inhibitorTakedowns = inhibitorTakedowns;
    }

    public int getInhibitorsLost() {
        return inhibitorsLost;
    }

    public void setInhibitorsLost(int inhibitorsLost) {
        this.inhibitorsLost = inhibitorsLost;
    }

    public int getItem0() {
        return item0;
    }

    public void setItem0(int item0) {
        this.item0 = item0;
    }

    public int getItem1() {
        return item1;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public int getItem3() {
        return item3;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public int getItem4() {
        return item4;
    }

    public void setItem4(int item4) {
        this.item4 = item4;
    }

    public int getItem5() {
        return item5;
    }

    public void setItem5(int item5) {
        this.item5 = item5;
    }

    public int getItem6() {
        return item6;
    }

    public void setItem6(int item6) {
        this.item6 = item6;
    }

    public int getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(int itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public int getKillingSprees() {
        return killingSprees;
    }

    public void setKillingSprees(int killingSprees) {
        this.killingSprees = killingSprees;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public int getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public void setLargestCriticalStrike(int largestCriticalStrike) {
        this.largestCriticalStrike = largestCriticalStrike;
    }

    public int getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree(int largestKillingSpree) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public int getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill(int largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    public int getLongestTimeSpentLiving() {
        return longestTimeSpentLiving;
    }

    public void setLongestTimeSpentLiving(int longestTimeSpentLiving) {
        this.longestTimeSpentLiving = longestTimeSpentLiving;
    }

    public int getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public void setMagicDamageDealt(int magicDamageDealt) {
        this.magicDamageDealt = magicDamageDealt;
    }

    public int getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public int getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public void setMagicDamageTaken(int magicDamageTaken) {
        this.magicDamageTaken = magicDamageTaken;
    }

    public Missions getMissions() {
        return missions;
    }

    public void setMissions(Missions missions) {
        this.missions = missions;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(int neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public int getNeedVisionPings() {
        return needVisionPings;
    }

    public void setNeedVisionPings(int needVisionPings) {
        this.needVisionPings = needVisionPings;
    }

    public int getNexusKills() {
        return nexusKills;
    }

    public void setNexusKills(int nexusKills) {
        this.nexusKills = nexusKills;
    }

    public int getNexusTakedowns() {
        return nexusTakedowns;
    }

    public void setNexusTakedowns(int nexusTakedowns) {
        this.nexusTakedowns = nexusTakedowns;
    }

    public int getNexusLost() {
        return nexusLost;
    }

    public void setNexusLost(int nexusLost) {
        this.nexusLost = nexusLost;
    }

    public int getObjectivesStolen() {
        return objectivesStolen;
    }

    public void setObjectivesStolen(int objectivesStolen) {
        this.objectivesStolen = objectivesStolen;
    }

    public int getObjectivesStolenAssists() {
        return objectivesStolenAssists;
    }

    public void setObjectivesStolenAssists(int objectivesStolenAssists) {
        this.objectivesStolenAssists = objectivesStolenAssists;
    }

    public int getOnMyWayPings() {
        return onMyWayPings;
    }

    public void setOnMyWayPings(int onMyWayPings) {
        this.onMyWayPings = onMyWayPings;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getPlayerScore0() {
        return playerScore0;
    }

    public void setPlayerScore0(int playerScore0) {
        this.playerScore0 = playerScore0;
    }

    public int getPlayerScore1() {
        return playerScore1;
    }

    public void setPlayerScore1(int playerScore1) {
        this.playerScore1 = playerScore1;
    }

    public int getPlayerScore2() {
        return playerScore2;
    }

    public void setPlayerScore2(int playerScore2) {
        this.playerScore2 = playerScore2;
    }

    public int getPlayerScore3() {
        return playerScore3;
    }

    public void setPlayerScore3(int playerScore3) {
        this.playerScore3 = playerScore3;
    }

    public int getPlayerScore4() {
        return playerScore4;
    }

    public void setPlayerScore4(int playerScore4) {
        this.playerScore4 = playerScore4;
    }

    public int getPlayerScore5() {
        return playerScore5;
    }

    public void setPlayerScore5(int playerScore5) {
        this.playerScore5 = playerScore5;
    }

    public int getPlayerScore6() {
        return playerScore6;
    }

    public void setPlayerScore6(int playerScore6) {
        this.playerScore6 = playerScore6;
    }

    public int getPlayerScore7() {
        return playerScore7;
    }

    public void setPlayerScore7(int playerScore7) {
        this.playerScore7 = playerScore7;
    }

    public int getPlayerScore8() {
        return playerScore8;
    }

    public void setPlayerScore8(int playerScore8) {
        this.playerScore8 = playerScore8;
    }

    public int getPlayerScore9() {
        return playerScore9;
    }

    public void setPlayerScore9(int playerScore9) {
        this.playerScore9 = playerScore9;
    }

    public int getPlayerScore10() {
        return playerScore10;
    }

    public void setPlayerScore10(int playerScore10) {
        this.playerScore10 = playerScore10;
    }

    public int getPlayerScore11() {
        return playerScore11;
    }

    public void setPlayerScore11(int playerScore11) {
        this.playerScore11 = playerScore11;
    }

    public int getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(int pentaKills) {
        this.pentaKills = pentaKills;
    }

    public Perks getPerks() {
        return perks;
    }

    public void setPerks(Perks perks) {
        this.perks = perks;
    }

    public int getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public void setPhysicalDamageDealt(int physicalDamageDealt) {
        this.physicalDamageDealt = physicalDamageDealt;
    }

    public int getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public int getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken(int physicalDamageTaken) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getPlayerAugment1() {
        return playerAugment1;
    }

    public void setPlayerAugment1(int playerAugment1) {
        this.playerAugment1 = playerAugment1;
    }

    public int getPlayerAugment2() {
        return playerAugment2;
    }

    public void setPlayerAugment2(int playerAugment2) {
        this.playerAugment2 = playerAugment2;
    }

    public int getPlayerAugment3() {
        return playerAugment3;
    }

    public void setPlayerAugment3(int playerAugment3) {
        this.playerAugment3 = playerAugment3;
    }

    public int getPlayerAugment4() {
        return playerAugment4;
    }

    public void setPlayerAugment4(int playerAugment4) {
        this.playerAugment4 = playerAugment4;
    }

    public int getPlayerSubteamId() {
        return playerSubteamId;
    }

    public void setPlayerSubteamId(int playerSubteamId) {
        this.playerSubteamId = playerSubteamId;
    }

    public int getPushPings() {
        return pushPings;
    }

    public void setPushPings(int pushPings) {
        this.pushPings = pushPings;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(int profileIcon) {
        this.profileIcon = profileIcon;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public int getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(int quadraKills) {
        this.quadraKills = quadraKills;
    }

    public String getRiotIdGameName() {
        return riotIdGameName;
    }

    public void setRiotIdGameName(String riotIdGameName) {
        this.riotIdGameName = riotIdGameName;
    }

    public String getRiotIdName() {
        return riotIdName;
    }

    public void setRiotIdName(String riotIdName) {
        this.riotIdName = riotIdName;
    }

    public String getRiotIdTagline() {
        return riotIdTagline;
    }

    public void setRiotIdTagline(String riotIdTagline) {
        this.riotIdTagline = riotIdTagline;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public void setSightWardsBoughtInGame(int sightWardsBoughtInGame) {
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    }

    public int getSpell1Casts() {
        return spell1Casts;
    }

    public void setSpell1Casts(int spell1Casts) {
        this.spell1Casts = spell1Casts;
    }

    public int getSpell2Casts() {
        return spell2Casts;
    }

    public void setSpell2Casts(int spell2Casts) {
        this.spell2Casts = spell2Casts;
    }

    public int getSpell3Casts() {
        return spell3Casts;
    }

    public void setSpell3Casts(int spell3Casts) {
        this.spell3Casts = spell3Casts;
    }

    public int getSpell4Casts() {
        return spell4Casts;
    }

    public void setSpell4Casts(int spell4Casts) {
        this.spell4Casts = spell4Casts;
    }

    public int getSubteamPlacement() {
        return subteamPlacement;
    }

    public void setSubteamPlacement(int subteamPlacement) {
        this.subteamPlacement = subteamPlacement;
    }

    public int getSummoner1Casts() {
        return summoner1Casts;
    }

    public void setSummoner1Casts(int summoner1Casts) {
        this.summoner1Casts = summoner1Casts;
    }

    public int getSummoner1Id() {
        return summoner1Id;
    }

    public void setSummoner1Id(int summoner1Id) {
        this.summoner1Id = summoner1Id;
    }

    public int getSummoner2Casts() {
        return summoner2Casts;
    }

    public void setSummoner2Casts(int summoner2Casts) {
        this.summoner2Casts = summoner2Casts;
    }

    public int getSummoner2Id() {
        return summoner2Id;
    }

    public void setSummoner2Id(int summoner2Id) {
        this.summoner2Id = summoner2Id;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public boolean isTeamEarlySurrendered() {
        return teamEarlySurrendered;
    }

    public void setTeamEarlySurrendered(boolean teamEarlySurrendered) {
        this.teamEarlySurrendered = teamEarlySurrendered;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamPosition() {
        return teamPosition;
    }

    public void setTeamPosition(String teamPosition) {
        this.teamPosition = teamPosition;
    }

    public int getTimeCCingOthers() {
        return timeCCingOthers;
    }

    public void setTimeCCingOthers(int timeCCingOthers) {
        this.timeCCingOthers = timeCCingOthers;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getTotalAllyJungleMinionsKilled() {
        return totalAllyJungleMinionsKilled;
    }

    public void setTotalAllyJungleMinionsKilled(int totalAllyJungleMinionsKilled) {
        this.totalAllyJungleMinionsKilled = totalAllyJungleMinionsKilled;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public int getTotalDamageShieldedOnTeammates() {
        return totalDamageShieldedOnTeammates;
    }

    public void setTotalDamageShieldedOnTeammates(int totalDamageShieldedOnTeammates) {
        this.totalDamageShieldedOnTeammates = totalDamageShieldedOnTeammates;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(int totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public int getTotalEnemyJungleMinionsKilled() {
        return totalEnemyJungleMinionsKilled;
    }

    public void setTotalEnemyJungleMinionsKilled(int totalEnemyJungleMinionsKilled) {
        this.totalEnemyJungleMinionsKilled = totalEnemyJungleMinionsKilled;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal(int totalHeal) {
        this.totalHeal = totalHeal;
    }

    public int getTotalHealsOnTeammates() {
        return totalHealsOnTeammates;
    }

    public void setTotalHealsOnTeammates(int totalHealsOnTeammates) {
        this.totalHealsOnTeammates = totalHealsOnTeammates;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(int totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public int getTotalTimeCCDealt() {
        return totalTimeCCDealt;
    }

    public void setTotalTimeCCDealt(int totalTimeCCDealt) {
        this.totalTimeCCDealt = totalTimeCCDealt;
    }

    public int getTotalTimeSpentDead() {
        return totalTimeSpentDead;
    }

    public void setTotalTimeSpentDead(int totalTimeSpentDead) {
        this.totalTimeSpentDead = totalTimeSpentDead;
    }

    public int getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public void setTotalUnitsHealed(int totalUnitsHealed) {
        this.totalUnitsHealed = totalUnitsHealed;
    }

    public int getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(int tripleKills) {
        this.tripleKills = tripleKills;
    }

    public int getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public void setTrueDamageDealt(int trueDamageDealt) {
        this.trueDamageDealt = trueDamageDealt;
    }

    public int getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public void setTrueDamageDealtToChampions(int trueDamageDealtToChampions) {
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    }

    public int getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public void setTrueDamageTaken(int trueDamageTaken) {
        this.trueDamageTaken = trueDamageTaken;
    }

    public int getTurretKills() {
        return turretKills;
    }

    public void setTurretKills(int turretKills) {
        this.turretKills = turretKills;
    }

    public int getTurretTakedowns() {
        return turretTakedowns;
    }

    public void setTurretTakedowns(int turretTakedowns) {
        this.turretTakedowns = turretTakedowns;
    }

    public int getTurretsLost() {
        return turretsLost;
    }

    public void setTurretsLost(int turretsLost) {
        this.turretsLost = turretsLost;
    }

    public int getUnrealKills() {
        return unrealKills;
    }

    public void setUnrealKills(int unrealKills) {
        this.unrealKills = unrealKills;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(int visionScore) {
        this.visionScore = visionScore;
    }

    public int getVisionClearedPings() {
        return visionClearedPings;
    }

    public void setVisionClearedPings(int visionClearedPings) {
        this.visionClearedPings = visionClearedPings;
    }

    public int getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public int getWardsKilled() {
        return wardsKilled;
    }

    public void setWardsKilled(int wardsKilled) {
        this.wardsKilled = wardsKilled;
    }

    public int getWardsPlaced() {
        return wardsPlaced;
    }

    public void setWardsPlaced(int wardsPlaced) {
        this.wardsPlaced = wardsPlaced;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getBasicPings() {
        return basicPings;
    }

    public void setBasicPings(int basicPings) {
        this.basicPings = basicPings;
    }

    public int getDangerPings() {
        return dangerPings;
    }

    public void setDangerPings(int dangerPings) {
        this.dangerPings = dangerPings;
    }

}
