package irelia.data.ddragon;

import java.util.HashMap;
import java.util.Map;

import irelia.core.Irelia;


public enum Champions {
    

	Aatrox(266,"Aatrox"),
	Ahri(103,"Ahri"),
	Akali(84,"Akali"),
	Akshan(166,"Akshan"),
	Alistar(12,"Alistar"),
	Ambessa(799,"Ambessa"),
	Amumu(32,"Amumu"),
	Anivia(34,"Anivia"),
	Annie(1,"Annie"),
	Aphelios(523,"Aphelios"),
	Ashe(22,"Ashe"),
	AurelionSol(136,"Aurelion Sol"),
	Aurora(893,"Aurora"),
	Azir(268,"Azir"),
	Bard(432,"Bard"),
	Belveth(200,"Bel'Veth"),
	Blitzcrank(53,"Blitzcrank"),
	Brand(63,"Brand"),
	Braum(201,"Braum"),
	Briar(233,"Briar"),
	Caitlyn(51,"Caitlyn"),
	Camille(164,"Camille"),
	Cassiopeia(69,"Cassiopeia"),
	Chogath(31,"Cho'Gath"),
	Corki(42,"Corki"),
	Darius(122,"Darius"),
	Diana(131,"Diana"),
	Draven(119,"Draven"),
	DrMundo(36,"Dr. Mundo"),
	Ekko(245,"Ekko"),
	Elise(60,"Elise"),
	Evelynn(28,"Evelynn"),
	Ezreal(81,"Ezreal"),
	Fiddlesticks(9,"Fiddlesticks"),
	Fiora(114,"Fiora"),
	Fizz(105,"Fizz"),
	Galio(3,"Galio"),
	Gangplank(41,"Gangplank"),
	Garen(86,"Garen"),
	Gnar(150,"Gnar"),
	Gragas(79,"Gragas"),
	Graves(104,"Graves"),
	Gwen(887,"Gwen"),
	Hecarim(120,"Hecarim"),
	Heimerdinger(74,"Heimerdinger"),
	Hwei(910,"Hwei"),
	Illaoi(420,"Illaoi"),
	Irelia(39,"Irelia"),
	Ivern(427,"Ivern"),
	Janna(40,"Janna"),
	JarvanIV(59,"Jarvan IV"),
	Jax(24,"Jax"),
	Jayce(126,"Jayce"),
	Jhin(202,"Jhin"),
	Jinx(222,"Jinx"),
	Kaisa(145,"Kai'Sa"),
	Kalista(429,"Kalista"),
	Karma(43,"Karma"),
	Karthus(30,"Karthus"),
	Kassadin(38,"Kassadin"),
	Katarina(55,"Katarina"),
	Kayle(10,"Kayle"),
	Kayn(141,"Kayn"),
	Kennen(85,"Kennen"),
	Khazix(121,"Kha'Zix"),
	Kindred(203,"Kindred"),
	Kled(240,"Kled"),
	KogMaw(96,"Kog'Maw"),
	KSante(897,"K'Sante"),
	Leblanc(7,"LeBlanc"),
	LeeSin(64,"Lee Sin"),
	Leona(89,"Leona"),
	Lillia(876,"Lillia"),
	Lissandra(127,"Lissandra"),
	Lucian(236,"Lucian"),
	Lulu(117,"Lulu"),
	Lux(99,"Lux"),
	Malphite(54,"Malphite"),
	Malzahar(90,"Malzahar"),
	Maokai(57,"Maokai"),
	MasterYi(11,"Master Yi"),
	Milio(902,"Milio"),
	MissFortune(21,"Miss Fortune"),
	MonkeyKing(62,"Wukong"),
	Mordekaiser(82,"Mordekaiser"),
	Morgana(25,"Morgana"),
	Naafiri(950,"Naafiri"),
	Nami(267,"Nami"),
	Nasus(75,"Nasus"),
	Nautilus(111,"Nautilus"),
	Neeko(518,"Neeko"),
	Nidalee(76,"Nidalee"),
	Nilah(895,"Nilah"),
	Nocturne(56,"Nocturne"),
	Nunu(20,"Nunu & Willump"),
	Olaf(2,"Olaf"),
	Orianna(61,"Orianna"),
	Ornn(516,"Ornn"),
	Pantheon(80,"Pantheon"),
	Poppy(78,"Poppy"),
	Pyke(555,"Pyke"),
	Qiyana(246,"Qiyana"),
	Quinn(133,"Quinn"),
	Rakan(497,"Rakan"),
	Rammus(33,"Rammus"),
	RekSai(421,"Rek'Sai"),
	Rell(526,"Rell"),
	Renata(888,"Renata Glasc"),
	Renekton(58,"Renekton"),
	Rengar(107,"Rengar"),
	Riven(92,"Riven"),
	Rumble(68,"Rumble"),
	Ryze(13,"Ryze"),
	Samira(360,"Samira"),
	Sejuani(113,"Sejuani"),
	Senna(235,"Senna"),
	Seraphine(147,"Seraphine"),
	Sett(875,"Sett"),
	Shaco(35,"Shaco"),
	Shen(98,"Shen"),
	Shyvana(102,"Shyvana"),
	Singed(27,"Singed"),
	Sion(14,"Sion"),
	Sivir(15,"Sivir"),
	Skarner(72,"Skarner"),
	Smolder(901,"Smolder"),
	Sona(37,"Sona"),
	Soraka(16,"Soraka"),
	Swain(50,"Swain"),
	Sylas(517,"Sylas"),
	Syndra(134,"Syndra"),
	TahmKench(223,"Tahm Kench"),
	Taliyah(163,"Taliyah"),
	Talon(91,"Talon"),
	Taric(44,"Taric"),
	Teemo(17,"Teemo"),
	Thresh(412,"Thresh"),
	Tristana(18,"Tristana"),
	Trundle(48,"Trundle"),
	Tryndamere(23,"Tryndamere"),
	TwistedFate(4,"Twisted Fate"),
	Twitch(29,"Twitch"),
	Udyr(77,"Udyr"),
	Urgot(6,"Urgot"),
	Varus(110,"Varus"),
	Vayne(67,"Vayne"),
	Veigar(45,"Veigar"),
	Velkoz(161,"Vel'Koz"),
	Vex(711,"Vex"),
	Vi(254,"Vi"),
	Viego(234,"Viego"),
	Viktor(112,"Viktor"),
	Vladimir(8,"Vladimir"),
	Volibear(106,"Volibear"),
	Warwick(19,"Warwick"),
	Xayah(498,"Xayah"),
	Xerath(101,"Xerath"),
	XinZhao(5,"Xin Zhao"),
	Yasuo(157,"Yasuo"),
	Yone(777,"Yone"),
	Yorick(83,"Yorick"),
	Yuumi(350,"Yuumi"),
	Zac(154,"Zac"),
	Zed(238,"Zed"),
	Zeri(221,"Zeri"),
	Ziggs(115,"Ziggs"),
	Zilean(26,"Zilean"),
	Zoe(142,"Zoe"),
	Zyra(143,"Zyra");

	private long key;
	
	private String label;

	private static final Map<Long, Champions> keyMap;

	static {
        keyMap = new HashMap<>();
        for (Champions c : values())
            keyMap.put(c.getKey(), c);
    }

	private Champions(long key, String label) {
        this.key = key;
        this.label = label;
    }
	
    public long getKey() {
        return key;
    }

	public String getLabel() {
        return label;
    }

	public static Champions getByKey(long key) {
        return keyMap.get(key);
    }

	public ChampionInfo info(Irelia irelia) {
		return irelia.ddragon().getDDragon().join().getChampion(this);
	}

}
