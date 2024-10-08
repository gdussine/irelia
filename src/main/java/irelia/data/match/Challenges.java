package irelia.data.match;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Challenges {

    @JsonProperty("12AssistStreakCount")
    private int assist12StreakCount;

    private int baronBuffGoldAdvantageOverThreshold;

    private float controlWardTimeCoverageInRiverOrEnemyHalf;

    private int earliestBaron, earliestDragonTakedown, earliestElderDragon, earlyLaningPhaseGoldExpAdvantage;

    private int fasterSupportQuestCompletion, fastestLegendary;

    private int hadAfkTeammate;

    private int highestChampionDamage;

    private int highestCrowdControlScore;

    private int highestWardKills;

    private int junglerKillsEarlyJungle;

    private int killsOnLanersEarlyJungleAsJungler;

    private int laningPhaseGoldExpAdvantage;
    private int legendaryCount;
    private float maxCsAdvantageOnLaneOpponent;
    private int maxLevelLeadLaneOpponent;
    private int mostWardsDestroyedOneSweeper;
    private int mythicItemUsed;
    private int playedChampSelectPosition;
    private int soloTurretsLategame;
    private int takedownsFirst25Minutes;
    private int teleportTakedowns;
    private int thirdInhibitorDestroyedTime;
    private int threeWardsOneSweeperCount;
    private float visionScoreAdvantageLaneOpponent;
    private int InfernalScalePickup;
    private int fistBumpParticipation;
    private int voidMonsterKill;
    private int abilityUses;
    private int acesBefore15Minutes;
    private float alliedJungleMonsterKills;
    private int baronTakedowns;
    private int blastConeOppositeOpponentCount;
    private int bountyGold;
    private int buffsStolen;
    private int completeSupportQuestInTime;
    private int controlWardsPlaced;
    private float damagePerMinute;
    private float damageTakenOnTeamPercentage;
    private int dancedWithRiftHerald;
    private int deathsByEnemyChamps;
    private int dodgeSkillShotsSmallWindow;
    private int doubleAces;
    private int dragonTakedowns;
    private List<Integer> legendaryItemUsed;
    private float effectiveHealAndShielding;
    private int elderDragonKillsWithOpposingSoul;
    private int elderDragonMultikills;
    private int enemyChampionImmobilizations;
    private float enemyJungleMonsterKills;
    private int epicMonsterKillsNearEnemyJungler;
    private int epicMonsterKillsWithin30SecondsOfSpawn;
    private int epicMonsterSteals;
    private int epicMonsterStolenWithoutSmite;
    private int firstTurretKilled;
    private float firstTurretKilledTime;
    private int flawlessAces;
    private int fullTeamTakedown;
    private float gameLength;
    private int getTakedownsInAllLanesEarlyJungleAsLaner;
    private float goldPerMinute;
    private int hadOpenNexus;
    private int immobilizeAndKillWithAlly;
    private int initialBuffCount;
    private int initialCrabCount;
    private float jungleCsBefore10Minutes;
    private int junglerTakedownsNearDamagedEpicMonster;
    private float kda;
    private int killAfterHiddenWithAlly;
    private int killedChampTookFullTeamDamageSurvived;
    private int killingSprees;
    private float killParticipation;
    private int killsNearEnemyTurret;
    private int killsOnOtherLanesEarlyJungleAsLaner;
    private int killsOnRecentlyHealedByAramPack;
    private int killsUnderOwnTurret;
    private int killsWithHelpFromEpicMonster;
    private int knockEnemyIntoTeamAndKill;
    private int kTurretsDestroyedBeforePlatesFall;
    private int landSkillShotsEarlyGame;
    private int laneMinionsFirst10Minutes;
    private int lostAnInhibitor;
    private int maxKillDeficit;
    private int mejaisFullStackInTime;
    private float moreEnemyJungleThanOpponent;
    private int multiKillOneSpell;
    private int multikills;
    private int multikillsAfterAggressiveFlash;
    private int multiTurretRiftHeraldCount;
    private int outerTurretExecutesBefore10Minutes;
    private int outnumberedKills;
    private int outnumberedNexusKill;
    private int perfectDragonSoulsTaken;
    private int perfectGame;
    private int pickKillWithAlly;
    private int poroExplosions;
    private int quickCleanse;
    private int quickFirstTurret;
    private int quickSoloKills;
    private int riftHeraldTakedowns;
    private int saveAllyFromDeath;
    private int scuttleCrabKills;
    private float shortestTimeToAceFromFirstTakedown;
    private int skillshotsDodged;
    private int skillshotsHit;
    private int snowballsHit;
    private int soloBaronKills;
    private int SWARM_DefeatAatrox;
    private int SWARM_DefeatBriar;
    private int SWARM_DefeatMiniBosses;
    private int SWARM_EvolveWeapon;
    private int SWARM_Have3Passives;
    private int SWARM_KillEnemy;
    private float SWARM_PickupGold;
    private int SWARM_ReachLevel50;
    private int SWARM_Survive15Min;
    private int SWARM_WinWith5EvolvedWeapons;
    private int soloKills;
    private int stealthWardsPlaced;
    private int survivedSingleDigitHpCount;
    private int survivedThreeImmobilizesInFight;
    private int takedownOnFirstTurret;
    private int takedowns;
    private int takedownsAfterGainingLevelAdvantage;
    private int takedownsBeforeJungleMinionSpawn;
    private int takedownsFirstXMinutes;
    private int takedownsInAlcove;
    private int takedownsInEnemyFountain;
    private int teamBaronKills;
    private float teamDamagePercentage;
    private int teamElderDragonKills;
    private int teamRiftHeraldKills;
    private int tookLargeDamageSurvived;
    private int turretPlatesTaken;
    private int turretsTakenWithRiftHerald;
    private int turretTakedowns;
    private int twentyMinionsIn3SecondsCount;
    private int twoWardsOneSweeperCount;
    private int unseenRecalls;
    private float visionScorePerMinute;
    private int wardsGuarded;
    private int wardTakedowns;
    private int wardTakedownsBefore20M;

    @JsonProperty("HealFromMapSources")
    private int healFromMapSources;

    @JsonProperty("InfernalScalePickup")
    private int infernalScalePickup;
    
    
    public int getAssist12StreakCount() {
        return assist12StreakCount;
    }
    public void setAssist12StreakCount(int assist12StreakCount) {
        this.assist12StreakCount = assist12StreakCount;
    }
    public int getBaronBuffGoldAdvantageOverThreshold() {
        return baronBuffGoldAdvantageOverThreshold;
    }
    public void setBaronBuffGoldAdvantageOverThreshold(int baronBuffGoldAdvantageOverThreshold) {
        this.baronBuffGoldAdvantageOverThreshold = baronBuffGoldAdvantageOverThreshold;
    }
    public float getControlWardTimeCoverageInRiverOrEnemyHalf() {
        return controlWardTimeCoverageInRiverOrEnemyHalf;
    }
    public void setControlWardTimeCoverageInRiverOrEnemyHalf(float controlWardTimeCoverageInRiverOrEnemyHalf) {
        this.controlWardTimeCoverageInRiverOrEnemyHalf = controlWardTimeCoverageInRiverOrEnemyHalf;
    }
    public int getEarliestBaron() {
        return earliestBaron;
    }
    public void setEarliestBaron(int earliestBaron) {
        this.earliestBaron = earliestBaron;
    }
    public int getEarliestDragonTakedown() {
        return earliestDragonTakedown;
    }
    public void setEarliestDragonTakedown(int earliestDragonTakedown) {
        this.earliestDragonTakedown = earliestDragonTakedown;
    }
    public int getEarliestElderDragon() {
        return earliestElderDragon;
    }
    public void setEarliestElderDragon(int earliestElderDragon) {
        this.earliestElderDragon = earliestElderDragon;
    }
    public int getEarlyLaningPhaseGoldExpAdvantage() {
        return earlyLaningPhaseGoldExpAdvantage;
    }
    public void setEarlyLaningPhaseGoldExpAdvantage(int earlyLaningPhaseGoldExpAdvantage) {
        this.earlyLaningPhaseGoldExpAdvantage = earlyLaningPhaseGoldExpAdvantage;
    }
    public int getFasterSupportQuestCompletion() {
        return fasterSupportQuestCompletion;
    }
    public void setFasterSupportQuestCompletion(int fasterSupportQuestCompletion) {
        this.fasterSupportQuestCompletion = fasterSupportQuestCompletion;
    }
    public int getFastestLegendary() {
        return fastestLegendary;
    }
    public void setFastestLegendary(int fastestLegendary) {
        this.fastestLegendary = fastestLegendary;
    }
    public int getHadAfkTeammate() {
        return hadAfkTeammate;
    }
    public void setHadAfkTeammate(int hadAfkTeammate) {
        this.hadAfkTeammate = hadAfkTeammate;
    }
    public int getHighestChampionDamage() {
        return highestChampionDamage;
    }
    public void setHighestChampionDamage(int highestChampionDamage) {
        this.highestChampionDamage = highestChampionDamage;
    }
    public int getHighestCrowdControlScore() {
        return highestCrowdControlScore;
    }
    public void setHighestCrowdControlScore(int highestCrowdControlScore) {
        this.highestCrowdControlScore = highestCrowdControlScore;
    }
    public int getHighestWardKills() {
        return highestWardKills;
    }
    public void setHighestWardKills(int highestWardKills) {
        this.highestWardKills = highestWardKills;
    }
    public int getJunglerKillsEarlyJungle() {
        return junglerKillsEarlyJungle;
    }
    public void setJunglerKillsEarlyJungle(int junglerKillsEarlyJungle) {
        this.junglerKillsEarlyJungle = junglerKillsEarlyJungle;
    }
    public int getKillsOnLanersEarlyJungleAsJungler() {
        return killsOnLanersEarlyJungleAsJungler;
    }
    public void setKillsOnLanersEarlyJungleAsJungler(int killsOnLanersEarlyJungleAsJungler) {
        this.killsOnLanersEarlyJungleAsJungler = killsOnLanersEarlyJungleAsJungler;
    }
    public int getLaningPhaseGoldExpAdvantage() {
        return laningPhaseGoldExpAdvantage;
    }
    public void setLaningPhaseGoldExpAdvantage(int laningPhaseGoldExpAdvantage) {
        this.laningPhaseGoldExpAdvantage = laningPhaseGoldExpAdvantage;
    }
    public int getLegendaryCount() {
        return legendaryCount;
    }
    public void setLegendaryCount(int legendaryCount) {
        this.legendaryCount = legendaryCount;
    }
    public float getMaxCsAdvantageOnLaneOpponent() {
        return maxCsAdvantageOnLaneOpponent;
    }
    public void setMaxCsAdvantageOnLaneOpponent(float maxCsAdvantageOnLaneOpponent) {
        this.maxCsAdvantageOnLaneOpponent = maxCsAdvantageOnLaneOpponent;
    }
    public int getMaxLevelLeadLaneOpponent() {
        return maxLevelLeadLaneOpponent;
    }
    public void setMaxLevelLeadLaneOpponent(int maxLevelLeadLaneOpponent) {
        this.maxLevelLeadLaneOpponent = maxLevelLeadLaneOpponent;
    }
    public int getMostWardsDestroyedOneSweeper() {
        return mostWardsDestroyedOneSweeper;
    }
    public void setMostWardsDestroyedOneSweeper(int mostWardsDestroyedOneSweeper) {
        this.mostWardsDestroyedOneSweeper = mostWardsDestroyedOneSweeper;
    }
    public int getMythicItemUsed() {
        return mythicItemUsed;
    }
    public void setMythicItemUsed(int mythicItemUsed) {
        this.mythicItemUsed = mythicItemUsed;
    }
    public int getPlayedChampSelectPosition() {
        return playedChampSelectPosition;
    }
    public void setPlayedChampSelectPosition(int playedChampSelectPosition) {
        this.playedChampSelectPosition = playedChampSelectPosition;
    }
    public int getSoloTurretsLategame() {
        return soloTurretsLategame;
    }
    public void setSoloTurretsLategame(int soloTurretsLategame) {
        this.soloTurretsLategame = soloTurretsLategame;
    }
    public int getTakedownsFirst25Minutes() {
        return takedownsFirst25Minutes;
    }
    public void setTakedownsFirst25Minutes(int takedownsFirst25Minutes) {
        this.takedownsFirst25Minutes = takedownsFirst25Minutes;
    }
    public int getTeleportTakedowns() {
        return teleportTakedowns;
    }
    public void setTeleportTakedowns(int teleportTakedowns) {
        this.teleportTakedowns = teleportTakedowns;
    }
    public int getThirdInhibitorDestroyedTime() {
        return thirdInhibitorDestroyedTime;
    }
    public void setThirdInhibitorDestroyedTime(int thirdInhibitorDestroyedTime) {
        this.thirdInhibitorDestroyedTime = thirdInhibitorDestroyedTime;
    }
    public int getThreeWardsOneSweeperCount() {
        return threeWardsOneSweeperCount;
    }
    public void setThreeWardsOneSweeperCount(int threeWardsOneSweeperCount) {
        this.threeWardsOneSweeperCount = threeWardsOneSweeperCount;
    }
    public float getVisionScoreAdvantageLaneOpponent() {
        return visionScoreAdvantageLaneOpponent;
    }
    public void setVisionScoreAdvantageLaneOpponent(float visionScoreAdvantageLaneOpponent) {
        this.visionScoreAdvantageLaneOpponent = visionScoreAdvantageLaneOpponent;
    }
    public int getInfernalScalePickup() {
        return InfernalScalePickup;
    }
    public void setInfernalScalePickup(int infernalScalePickup) {
        InfernalScalePickup = infernalScalePickup;
    }
    public int getFistBumpParticipation() {
        return fistBumpParticipation;
    }
    public void setFistBumpParticipation(int fistBumpParticipation) {
        this.fistBumpParticipation = fistBumpParticipation;
    }
    public int getVoidMonsterKill() {
        return voidMonsterKill;
    }
    public void setVoidMonsterKill(int voidMonsterKill) {
        this.voidMonsterKill = voidMonsterKill;
    }
    public int getAbilityUses() {
        return abilityUses;
    }
    public void setAbilityUses(int abilityUses) {
        this.abilityUses = abilityUses;
    }
    public int getAcesBefore15Minutes() {
        return acesBefore15Minutes;
    }
    public void setAcesBefore15Minutes(int acesBefore15Minutes) {
        this.acesBefore15Minutes = acesBefore15Minutes;
    }
    public float getAlliedJungleMonsterKills() {
        return alliedJungleMonsterKills;
    }
    public void setAlliedJungleMonsterKills(float alliedJungleMonsterKills) {
        this.alliedJungleMonsterKills = alliedJungleMonsterKills;
    }
    public int getBaronTakedowns() {
        return baronTakedowns;
    }
    public void setBaronTakedowns(int baronTakedowns) {
        this.baronTakedowns = baronTakedowns;
    }
    public int getBlastConeOppositeOpponentCount() {
        return blastConeOppositeOpponentCount;
    }
    public void setBlastConeOppositeOpponentCount(int blastConeOppositeOpponentCount) {
        this.blastConeOppositeOpponentCount = blastConeOppositeOpponentCount;
    }
    public int getBountyGold() {
        return bountyGold;
    }
    public void setBountyGold(int bountyGold) {
        this.bountyGold = bountyGold;
    }
    public int getBuffsStolen() {
        return buffsStolen;
    }
    public void setBuffsStolen(int buffsStolen) {
        this.buffsStolen = buffsStolen;
    }
    public int getCompleteSupportQuestInTime() {
        return completeSupportQuestInTime;
    }
    public void setCompleteSupportQuestInTime(int completeSupportQuestInTime) {
        this.completeSupportQuestInTime = completeSupportQuestInTime;
    }
    public int getControlWardsPlaced() {
        return controlWardsPlaced;
    }
    public void setControlWardsPlaced(int controlWardsPlaced) {
        this.controlWardsPlaced = controlWardsPlaced;
    }
    public float getDamagePerMinute() {
        return damagePerMinute;
    }
    public void setDamagePerMinute(float damagePerMinute) {
        this.damagePerMinute = damagePerMinute;
    }
    public float getDamageTakenOnTeamPercentage() {
        return damageTakenOnTeamPercentage;
    }
    public void setDamageTakenOnTeamPercentage(float damageTakenOnTeamPercentage) {
        this.damageTakenOnTeamPercentage = damageTakenOnTeamPercentage;
    }
    public int getDancedWithRiftHerald() {
        return dancedWithRiftHerald;
    }
    public void setDancedWithRiftHerald(int dancedWithRiftHerald) {
        this.dancedWithRiftHerald = dancedWithRiftHerald;
    }
    public int getDeathsByEnemyChamps() {
        return deathsByEnemyChamps;
    }
    public void setDeathsByEnemyChamps(int deathsByEnemyChamps) {
        this.deathsByEnemyChamps = deathsByEnemyChamps;
    }
    public int getDodgeSkillShotsSmallWindow() {
        return dodgeSkillShotsSmallWindow;
    }
    public void setDodgeSkillShotsSmallWindow(int dodgeSkillShotsSmallWindow) {
        this.dodgeSkillShotsSmallWindow = dodgeSkillShotsSmallWindow;
    }
    public int getDoubleAces() {
        return doubleAces;
    }
    public void setDoubleAces(int doubleAces) {
        this.doubleAces = doubleAces;
    }
    public int getDragonTakedowns() {
        return dragonTakedowns;
    }
    public void setDragonTakedowns(int dragonTakedowns) {
        this.dragonTakedowns = dragonTakedowns;
    }
    public List<Integer> getLegendaryItemUsed() {
        return legendaryItemUsed;
    }
    public void setLegendaryItemUsed(List<Integer> legendaryItemUsed) {
        this.legendaryItemUsed = legendaryItemUsed;
    }
    public float getEffectiveHealAndShielding() {
        return effectiveHealAndShielding;
    }
    public void setEffectiveHealAndShielding(float effectiveHealAndShielding) {
        this.effectiveHealAndShielding = effectiveHealAndShielding;
    }
    public int getElderDragonKillsWithOpposingSoul() {
        return elderDragonKillsWithOpposingSoul;
    }
    public void setElderDragonKillsWithOpposingSoul(int elderDragonKillsWithOpposingSoul) {
        this.elderDragonKillsWithOpposingSoul = elderDragonKillsWithOpposingSoul;
    }
    public int getElderDragonMultikills() {
        return elderDragonMultikills;
    }
    public void setElderDragonMultikills(int elderDragonMultikills) {
        this.elderDragonMultikills = elderDragonMultikills;
    }
    public int getEnemyChampionImmobilizations() {
        return enemyChampionImmobilizations;
    }
    public void setEnemyChampionImmobilizations(int enemyChampionImmobilizations) {
        this.enemyChampionImmobilizations = enemyChampionImmobilizations;
    }
    public float getEnemyJungleMonsterKills() {
        return enemyJungleMonsterKills;
    }
    public void setEnemyJungleMonsterKills(float enemyJungleMonsterKills) {
        this.enemyJungleMonsterKills = enemyJungleMonsterKills;
    }
    public int getEpicMonsterKillsNearEnemyJungler() {
        return epicMonsterKillsNearEnemyJungler;
    }
    public void setEpicMonsterKillsNearEnemyJungler(int epicMonsterKillsNearEnemyJungler) {
        this.epicMonsterKillsNearEnemyJungler = epicMonsterKillsNearEnemyJungler;
    }
    public int getEpicMonsterKillsWithin30SecondsOfSpawn() {
        return epicMonsterKillsWithin30SecondsOfSpawn;
    }
    public void setEpicMonsterKillsWithin30SecondsOfSpawn(int epicMonsterKillsWithin30SecondsOfSpawn) {
        this.epicMonsterKillsWithin30SecondsOfSpawn = epicMonsterKillsWithin30SecondsOfSpawn;
    }
    public int getEpicMonsterSteals() {
        return epicMonsterSteals;
    }
    public void setEpicMonsterSteals(int epicMonsterSteals) {
        this.epicMonsterSteals = epicMonsterSteals;
    }
    public int getEpicMonsterStolenWithoutSmite() {
        return epicMonsterStolenWithoutSmite;
    }
    public void setEpicMonsterStolenWithoutSmite(int epicMonsterStolenWithoutSmite) {
        this.epicMonsterStolenWithoutSmite = epicMonsterStolenWithoutSmite;
    }
    public int getFirstTurretKilled() {
        return firstTurretKilled;
    }
    public void setFirstTurretKilled(int firstTurretKilled) {
        this.firstTurretKilled = firstTurretKilled;
    }
    public float getFirstTurretKilledTime() {
        return firstTurretKilledTime;
    }
    public void setFirstTurretKilledTime(float firstTurretKilledTime) {
        this.firstTurretKilledTime = firstTurretKilledTime;
    }
    public int getFlawlessAces() {
        return flawlessAces;
    }
    public void setFlawlessAces(int flawlessAces) {
        this.flawlessAces = flawlessAces;
    }
    public int getFullTeamTakedown() {
        return fullTeamTakedown;
    }
    public void setFullTeamTakedown(int fullTeamTakedown) {
        this.fullTeamTakedown = fullTeamTakedown;
    }
    public float getGameLength() {
        return gameLength;
    }
    public void setGameLength(float gameLength) {
        this.gameLength = gameLength;
    }
    public int getGetTakedownsInAllLanesEarlyJungleAsLaner() {
        return getTakedownsInAllLanesEarlyJungleAsLaner;
    }
    public void setGetTakedownsInAllLanesEarlyJungleAsLaner(int getTakedownsInAllLanesEarlyJungleAsLaner) {
        this.getTakedownsInAllLanesEarlyJungleAsLaner = getTakedownsInAllLanesEarlyJungleAsLaner;
    }
    public float getGoldPerMinute() {
        return goldPerMinute;
    }
    public void setGoldPerMinute(float goldPerMinute) {
        this.goldPerMinute = goldPerMinute;
    }
    public int getHadOpenNexus() {
        return hadOpenNexus;
    }
    public void setHadOpenNexus(int hadOpenNexus) {
        this.hadOpenNexus = hadOpenNexus;
    }
    public int getImmobilizeAndKillWithAlly() {
        return immobilizeAndKillWithAlly;
    }
    public void setImmobilizeAndKillWithAlly(int immobilizeAndKillWithAlly) {
        this.immobilizeAndKillWithAlly = immobilizeAndKillWithAlly;
    }
    public int getInitialBuffCount() {
        return initialBuffCount;
    }
    public void setInitialBuffCount(int initialBuffCount) {
        this.initialBuffCount = initialBuffCount;
    }
    public int getInitialCrabCount() {
        return initialCrabCount;
    }
    public void setInitialCrabCount(int initialCrabCount) {
        this.initialCrabCount = initialCrabCount;
    }
    public float getJungleCsBefore10Minutes() {
        return jungleCsBefore10Minutes;
    }
    public void setJungleCsBefore10Minutes(float jungleCsBefore10Minutes) {
        this.jungleCsBefore10Minutes = jungleCsBefore10Minutes;
    }
    public int getJunglerTakedownsNearDamagedEpicMonster() {
        return junglerTakedownsNearDamagedEpicMonster;
    }
    public void setJunglerTakedownsNearDamagedEpicMonster(int junglerTakedownsNearDamagedEpicMonster) {
        this.junglerTakedownsNearDamagedEpicMonster = junglerTakedownsNearDamagedEpicMonster;
    }
    public float getKda() {
        return kda;
    }
    public void setKda(float kda) {
        this.kda = kda;
    }
    public int getKillAfterHiddenWithAlly() {
        return killAfterHiddenWithAlly;
    }
    public void setKillAfterHiddenWithAlly(int killAfterHiddenWithAlly) {
        this.killAfterHiddenWithAlly = killAfterHiddenWithAlly;
    }
    public int getKilledChampTookFullTeamDamageSurvived() {
        return killedChampTookFullTeamDamageSurvived;
    }
    public void setKilledChampTookFullTeamDamageSurvived(int killedChampTookFullTeamDamageSurvived) {
        this.killedChampTookFullTeamDamageSurvived = killedChampTookFullTeamDamageSurvived;
    }
    public int getKillingSprees() {
        return killingSprees;
    }
    public void setKillingSprees(int killingSprees) {
        this.killingSprees = killingSprees;
    }
    public float getKillParticipation() {
        return killParticipation;
    }
    public void setKillParticipation(float killParticipation) {
        this.killParticipation = killParticipation;
    }
    public int getKillsNearEnemyTurret() {
        return killsNearEnemyTurret;
    }
    public void setKillsNearEnemyTurret(int killsNearEnemyTurret) {
        this.killsNearEnemyTurret = killsNearEnemyTurret;
    }
    public int getKillsOnOtherLanesEarlyJungleAsLaner() {
        return killsOnOtherLanesEarlyJungleAsLaner;
    }
    public void setKillsOnOtherLanesEarlyJungleAsLaner(int killsOnOtherLanesEarlyJungleAsLaner) {
        this.killsOnOtherLanesEarlyJungleAsLaner = killsOnOtherLanesEarlyJungleAsLaner;
    }
    public int getKillsOnRecentlyHealedByAramPack() {
        return killsOnRecentlyHealedByAramPack;
    }
    public void setKillsOnRecentlyHealedByAramPack(int killsOnRecentlyHealedByAramPack) {
        this.killsOnRecentlyHealedByAramPack = killsOnRecentlyHealedByAramPack;
    }
    public int getKillsUnderOwnTurret() {
        return killsUnderOwnTurret;
    }
    public void setKillsUnderOwnTurret(int killsUnderOwnTurret) {
        this.killsUnderOwnTurret = killsUnderOwnTurret;
    }
    public int getKillsWithHelpFromEpicMonster() {
        return killsWithHelpFromEpicMonster;
    }
    public void setKillsWithHelpFromEpicMonster(int killsWithHelpFromEpicMonster) {
        this.killsWithHelpFromEpicMonster = killsWithHelpFromEpicMonster;
    }
    public int getKnockEnemyIntoTeamAndKill() {
        return knockEnemyIntoTeamAndKill;
    }
    public void setKnockEnemyIntoTeamAndKill(int knockEnemyIntoTeamAndKill) {
        this.knockEnemyIntoTeamAndKill = knockEnemyIntoTeamAndKill;
    }
    public int getkTurretsDestroyedBeforePlatesFall() {
        return kTurretsDestroyedBeforePlatesFall;
    }
    public void setkTurretsDestroyedBeforePlatesFall(int kTurretsDestroyedBeforePlatesFall) {
        this.kTurretsDestroyedBeforePlatesFall = kTurretsDestroyedBeforePlatesFall;
    }
    public int getLandSkillShotsEarlyGame() {
        return landSkillShotsEarlyGame;
    }
    public void setLandSkillShotsEarlyGame(int landSkillShotsEarlyGame) {
        this.landSkillShotsEarlyGame = landSkillShotsEarlyGame;
    }
    public int getLaneMinionsFirst10Minutes() {
        return laneMinionsFirst10Minutes;
    }
    public void setLaneMinionsFirst10Minutes(int laneMinionsFirst10Minutes) {
        this.laneMinionsFirst10Minutes = laneMinionsFirst10Minutes;
    }
    public int getLostAnInhibitor() {
        return lostAnInhibitor;
    }
    public void setLostAnInhibitor(int lostAnInhibitor) {
        this.lostAnInhibitor = lostAnInhibitor;
    }
    public int getMaxKillDeficit() {
        return maxKillDeficit;
    }
    public void setMaxKillDeficit(int maxKillDeficit) {
        this.maxKillDeficit = maxKillDeficit;
    }
    public int getMejaisFullStackInTime() {
        return mejaisFullStackInTime;
    }
    public void setMejaisFullStackInTime(int mejaisFullStackInTime) {
        this.mejaisFullStackInTime = mejaisFullStackInTime;
    }
    public float getMoreEnemyJungleThanOpponent() {
        return moreEnemyJungleThanOpponent;
    }
    public void setMoreEnemyJungleThanOpponent(float moreEnemyJungleThanOpponent) {
        this.moreEnemyJungleThanOpponent = moreEnemyJungleThanOpponent;
    }
    public int getMultiKillOneSpell() {
        return multiKillOneSpell;
    }
    public void setMultiKillOneSpell(int multiKillOneSpell) {
        this.multiKillOneSpell = multiKillOneSpell;
    }
    public int getMultikills() {
        return multikills;
    }
    public void setMultikills(int multikills) {
        this.multikills = multikills;
    }
    public int getMultikillsAfterAggressiveFlash() {
        return multikillsAfterAggressiveFlash;
    }
    public void setMultikillsAfterAggressiveFlash(int multikillsAfterAggressiveFlash) {
        this.multikillsAfterAggressiveFlash = multikillsAfterAggressiveFlash;
    }
    public int getMultiTurretRiftHeraldCount() {
        return multiTurretRiftHeraldCount;
    }
    public void setMultiTurretRiftHeraldCount(int multiTurretRiftHeraldCount) {
        this.multiTurretRiftHeraldCount = multiTurretRiftHeraldCount;
    }
    public int getOuterTurretExecutesBefore10Minutes() {
        return outerTurretExecutesBefore10Minutes;
    }
    public void setOuterTurretExecutesBefore10Minutes(int outerTurretExecutesBefore10Minutes) {
        this.outerTurretExecutesBefore10Minutes = outerTurretExecutesBefore10Minutes;
    }
    public int getOutnumberedKills() {
        return outnumberedKills;
    }
    public void setOutnumberedKills(int outnumberedKills) {
        this.outnumberedKills = outnumberedKills;
    }
    public int getOutnumberedNexusKill() {
        return outnumberedNexusKill;
    }
    public void setOutnumberedNexusKill(int outnumberedNexusKill) {
        this.outnumberedNexusKill = outnumberedNexusKill;
    }
    public int getPerfectDragonSoulsTaken() {
        return perfectDragonSoulsTaken;
    }
    public void setPerfectDragonSoulsTaken(int perfectDragonSoulsTaken) {
        this.perfectDragonSoulsTaken = perfectDragonSoulsTaken;
    }
    public int getPerfectGame() {
        return perfectGame;
    }
    public void setPerfectGame(int perfectGame) {
        this.perfectGame = perfectGame;
    }
    public int getPickKillWithAlly() {
        return pickKillWithAlly;
    }
    public void setPickKillWithAlly(int pickKillWithAlly) {
        this.pickKillWithAlly = pickKillWithAlly;
    }
    public int getPoroExplosions() {
        return poroExplosions;
    }
    public void setPoroExplosions(int poroExplosions) {
        this.poroExplosions = poroExplosions;
    }
    public int getQuickCleanse() {
        return quickCleanse;
    }
    public void setQuickCleanse(int quickCleanse) {
        this.quickCleanse = quickCleanse;
    }
    public int getQuickFirstTurret() {
        return quickFirstTurret;
    }
    public void setQuickFirstTurret(int quickFirstTurret) {
        this.quickFirstTurret = quickFirstTurret;
    }
    public int getQuickSoloKills() {
        return quickSoloKills;
    }
    public void setQuickSoloKills(int quickSoloKills) {
        this.quickSoloKills = quickSoloKills;
    }
    public int getRiftHeraldTakedowns() {
        return riftHeraldTakedowns;
    }
    public void setRiftHeraldTakedowns(int riftHeraldTakedowns) {
        this.riftHeraldTakedowns = riftHeraldTakedowns;
    }
    public int getSaveAllyFromDeath() {
        return saveAllyFromDeath;
    }
    public void setSaveAllyFromDeath(int saveAllyFromDeath) {
        this.saveAllyFromDeath = saveAllyFromDeath;
    }
    public int getScuttleCrabKills() {
        return scuttleCrabKills;
    }
    public void setScuttleCrabKills(int scuttleCrabKills) {
        this.scuttleCrabKills = scuttleCrabKills;
    }
    public float getShortestTimeToAceFromFirstTakedown() {
        return shortestTimeToAceFromFirstTakedown;
    }
    public void setShortestTimeToAceFromFirstTakedown(float shortestTimeToAceFromFirstTakedown) {
        this.shortestTimeToAceFromFirstTakedown = shortestTimeToAceFromFirstTakedown;
    }
    public int getSkillshotsDodged() {
        return skillshotsDodged;
    }
    public void setSkillshotsDodged(int skillshotsDodged) {
        this.skillshotsDodged = skillshotsDodged;
    }
    public int getSkillshotsHit() {
        return skillshotsHit;
    }
    public void setSkillshotsHit(int skillshotsHit) {
        this.skillshotsHit = skillshotsHit;
    }
    public int getSnowballsHit() {
        return snowballsHit;
    }
    public void setSnowballsHit(int snowballsHit) {
        this.snowballsHit = snowballsHit;
    }
    public int getSoloBaronKills() {
        return soloBaronKills;
    }
    public void setSoloBaronKills(int soloBaronKills) {
        this.soloBaronKills = soloBaronKills;
    }
    public int getSWARM_DefeatAatrox() {
        return SWARM_DefeatAatrox;
    }
    public void setSWARM_DefeatAatrox(int sWARM_DefeatAatrox) {
        SWARM_DefeatAatrox = sWARM_DefeatAatrox;
    }
    public int getSWARM_DefeatBriar() {
        return SWARM_DefeatBriar;
    }
    public void setSWARM_DefeatBriar(int sWARM_DefeatBriar) {
        SWARM_DefeatBriar = sWARM_DefeatBriar;
    }
    public int getSWARM_DefeatMiniBosses() {
        return SWARM_DefeatMiniBosses;
    }
    public void setSWARM_DefeatMiniBosses(int sWARM_DefeatMiniBosses) {
        SWARM_DefeatMiniBosses = sWARM_DefeatMiniBosses;
    }
    public int getSWARM_EvolveWeapon() {
        return SWARM_EvolveWeapon;
    }
    public void setSWARM_EvolveWeapon(int sWARM_EvolveWeapon) {
        SWARM_EvolveWeapon = sWARM_EvolveWeapon;
    }
    public int getSWARM_Have3Passives() {
        return SWARM_Have3Passives;
    }
    public void setSWARM_Have3Passives(int sWARM_Have3Passives) {
        SWARM_Have3Passives = sWARM_Have3Passives;
    }
    public int getSWARM_KillEnemy() {
        return SWARM_KillEnemy;
    }
    public void setSWARM_KillEnemy(int sWARM_KillEnemy) {
        SWARM_KillEnemy = sWARM_KillEnemy;
    }
    public float getSWARM_PickupGold() {
        return SWARM_PickupGold;
    }
    public void setSWARM_PickupGold(float sWARM_PickupGold) {
        SWARM_PickupGold = sWARM_PickupGold;
    }
    public int getSWARM_ReachLevel50() {
        return SWARM_ReachLevel50;
    }
    public void setSWARM_ReachLevel50(int sWARM_ReachLevel50) {
        SWARM_ReachLevel50 = sWARM_ReachLevel50;
    }
    public int getSWARM_Survive15Min() {
        return SWARM_Survive15Min;
    }
    public void setSWARM_Survive15Min(int sWARM_Survive15Min) {
        SWARM_Survive15Min = sWARM_Survive15Min;
    }
    public int getSWARM_WinWith5EvolvedWeapons() {
        return SWARM_WinWith5EvolvedWeapons;
    }
    public void setSWARM_WinWith5EvolvedWeapons(int sWARM_WinWith5EvolvedWeapons) {
        SWARM_WinWith5EvolvedWeapons = sWARM_WinWith5EvolvedWeapons;
    }
    public int getSoloKills() {
        return soloKills;
    }
    public void setSoloKills(int soloKills) {
        this.soloKills = soloKills;
    }
    public int getStealthWardsPlaced() {
        return stealthWardsPlaced;
    }
    public void setStealthWardsPlaced(int stealthWardsPlaced) {
        this.stealthWardsPlaced = stealthWardsPlaced;
    }
    public int getSurvivedSingleDigitHpCount() {
        return survivedSingleDigitHpCount;
    }
    public void setSurvivedSingleDigitHpCount(int survivedSingleDigitHpCount) {
        this.survivedSingleDigitHpCount = survivedSingleDigitHpCount;
    }
    public int getSurvivedThreeImmobilizesInFight() {
        return survivedThreeImmobilizesInFight;
    }
    public void setSurvivedThreeImmobilizesInFight(int survivedThreeImmobilizesInFight) {
        this.survivedThreeImmobilizesInFight = survivedThreeImmobilizesInFight;
    }
    public int getTakedownOnFirstTurret() {
        return takedownOnFirstTurret;
    }
    public void setTakedownOnFirstTurret(int takedownOnFirstTurret) {
        this.takedownOnFirstTurret = takedownOnFirstTurret;
    }
    public int getTakedowns() {
        return takedowns;
    }
    public void setTakedowns(int takedowns) {
        this.takedowns = takedowns;
    }
    public int getTakedownsAfterGainingLevelAdvantage() {
        return takedownsAfterGainingLevelAdvantage;
    }
    public void setTakedownsAfterGainingLevelAdvantage(int takedownsAfterGainingLevelAdvantage) {
        this.takedownsAfterGainingLevelAdvantage = takedownsAfterGainingLevelAdvantage;
    }
    public int getTakedownsBeforeJungleMinionSpawn() {
        return takedownsBeforeJungleMinionSpawn;
    }
    public void setTakedownsBeforeJungleMinionSpawn(int takedownsBeforeJungleMinionSpawn) {
        this.takedownsBeforeJungleMinionSpawn = takedownsBeforeJungleMinionSpawn;
    }
    public int getTakedownsFirstXMinutes() {
        return takedownsFirstXMinutes;
    }
    public void setTakedownsFirstXMinutes(int takedownsFirstXMinutes) {
        this.takedownsFirstXMinutes = takedownsFirstXMinutes;
    }
    public int getTakedownsInAlcove() {
        return takedownsInAlcove;
    }
    public void setTakedownsInAlcove(int takedownsInAlcove) {
        this.takedownsInAlcove = takedownsInAlcove;
    }
    public int getTakedownsInEnemyFountain() {
        return takedownsInEnemyFountain;
    }
    public void setTakedownsInEnemyFountain(int takedownsInEnemyFountain) {
        this.takedownsInEnemyFountain = takedownsInEnemyFountain;
    }
    public int getTeamBaronKills() {
        return teamBaronKills;
    }
    public void setTeamBaronKills(int teamBaronKills) {
        this.teamBaronKills = teamBaronKills;
    }
    public float getTeamDamagePercentage() {
        return teamDamagePercentage;
    }
    public void setTeamDamagePercentage(float teamDamagePercentage) {
        this.teamDamagePercentage = teamDamagePercentage;
    }
    public int getTeamElderDragonKills() {
        return teamElderDragonKills;
    }
    public void setTeamElderDragonKills(int teamElderDragonKills) {
        this.teamElderDragonKills = teamElderDragonKills;
    }
    public int getTeamRiftHeraldKills() {
        return teamRiftHeraldKills;
    }
    public void setTeamRiftHeraldKills(int teamRiftHeraldKills) {
        this.teamRiftHeraldKills = teamRiftHeraldKills;
    }
    public int getTookLargeDamageSurvived() {
        return tookLargeDamageSurvived;
    }
    public void setTookLargeDamageSurvived(int tookLargeDamageSurvived) {
        this.tookLargeDamageSurvived = tookLargeDamageSurvived;
    }
    public int getTurretPlatesTaken() {
        return turretPlatesTaken;
    }
    public void setTurretPlatesTaken(int turretPlatesTaken) {
        this.turretPlatesTaken = turretPlatesTaken;
    }
    public int getTurretsTakenWithRiftHerald() {
        return turretsTakenWithRiftHerald;
    }
    public void setTurretsTakenWithRiftHerald(int turretsTakenWithRiftHerald) {
        this.turretsTakenWithRiftHerald = turretsTakenWithRiftHerald;
    }
    public int getTurretTakedowns() {
        return turretTakedowns;
    }
    public void setTurretTakedowns(int turretTakedowns) {
        this.turretTakedowns = turretTakedowns;
    }
    public int getTwentyMinionsIn3SecondsCount() {
        return twentyMinionsIn3SecondsCount;
    }
    public void setTwentyMinionsIn3SecondsCount(int twentyMinionsIn3SecondsCount) {
        this.twentyMinionsIn3SecondsCount = twentyMinionsIn3SecondsCount;
    }
    public int getTwoWardsOneSweeperCount() {
        return twoWardsOneSweeperCount;
    }
    public void setTwoWardsOneSweeperCount(int twoWardsOneSweeperCount) {
        this.twoWardsOneSweeperCount = twoWardsOneSweeperCount;
    }
    public int getUnseenRecalls() {
        return unseenRecalls;
    }
    public void setUnseenRecalls(int unseenRecalls) {
        this.unseenRecalls = unseenRecalls;
    }
    public float getVisionScorePerMinute() {
        return visionScorePerMinute;
    }
    public void setVisionScorePerMinute(float visionScorePerMinute) {
        this.visionScorePerMinute = visionScorePerMinute;
    }
    public int getWardsGuarded() {
        return wardsGuarded;
    }
    public void setWardsGuarded(int wardsGuarded) {
        this.wardsGuarded = wardsGuarded;
    }
    public int getWardTakedowns() {
        return wardTakedowns;
    }
    public void setWardTakedowns(int wardTakedowns) {
        this.wardTakedowns = wardTakedowns;
    }
    public int getWardTakedownsBefore20M() {
        return wardTakedownsBefore20M;
    }
    public void setWardTakedownsBefore20M(int wardTakedownsBefore20M) {
        this.wardTakedownsBefore20M = wardTakedownsBefore20M;
    }
    public int getHealFromMapSources() {
        return healFromMapSources;
    }
    public void setHealFromMapSources(int healFromMapSources) {
        this.healFromMapSources = healFromMapSources;
    }
    
}
