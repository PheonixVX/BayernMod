package io.github.pheonixvx.bayernmod.init;

import io.github.pheonixvx.bayernmod.BayernMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //FOOD - ITEMS
    public static final Item BEER = registerItem("beer");
    public static final Item WEISSWURST = registerFoodItem(new Item.Settings().food(ModFoodComponents.COOKED_VEAL_SAUSAGE),"weisswurst");
    public static final Item WEISSWURSTROH = registerFoodItem(new Item.Settings().food(ModFoodComponents.UNCOOKED_VEAL_SAUSAGE),"weisswurstroh");
    public static final Item BREZE = registerItem("breze");
    public static final Item BREZENTEIG = registerItem("brezenteig");
    public static final Item BREZEMITSALZ = registerItem("brezemitsalz");
    public static final Item SALZ = registerItem("salz");
    public static final Item SEMMEL = registerItem("semmel");
    public static final Item SEMMELTEIG = registerItem("semmelteig");
    public static final Item WURSTROH = registerItem("wurstroh");
    public static final Item WURSTGEKOCHT = registerItem("wurstgekocht");
    public static final Item WURSTGEBRATEN = registerItem("wurstgebraten");
    public static final Item CURRYWURSTMITPOMMES = registerItem("currywurstmitpommes");
    public static final Item POMMESROH = registerItem("pommesroh");
    public static final Item POMMES = registerItem("pommes");
    public static final Item LEBERKAS = registerItem("leberkas");
    public static final Item LEBERKASROH = registerItem("leberkasroh");
    public static final Item SEMMELKNODEL = registerItem("semmelknodel");
    public static final Item SCHWEINEBRATEN = registerItem("schweinebraten");
    public static final Item MEHL = registerItem("mehl");
    public static final Item HACKBRATENROH = registerItem("hackbratenroh");
    public static final Item HACKBRATEN = registerItem("hackbraten");
    public static final Item KARTOFFELSALAT = registerItem("kartoffelsalat");

    //TOOLS
    public static final Item PFANNE = registerItem("pfanne");

    //WEAPON
    public static final Item KOCHLOFFEL = registerItem("kochloffel");
    public static final Item SENSE = registerItem("sense");
    public static final Item FACKEL = registerItem("fackel");
    public static final Item MISTGABEL = registerItem("mistgabel");

    //ARMOR
    public static final Item FILZHUT = registerItem("filzhut");
    public static final Item HEMD = registerItem("hemd");
    public static final Item LEDERHOSE = registerItem("lederhose");
    public static final Item SCHUH = registerItem("schuh");

    /* TODO: Texture items
    public static final Item WURSTDARM = registerItem("wurstdarm");
    public static final Item VERSALZENEBREZEMITSALZ = registerItem("versalzenebrezemitsalz");
    public static final Item BUTTERBREZE = registerItem("butterbreze");
    public static final Item BUTTERBREZEMITSALZ = registerItem("butterbrezemitsalz");
    public static final Item CURRYWURST = registerItem("currywurst");
    public static final Item POMMESMITSALZ = registerItem("pommesmitsalz");
    public static final Item VERSALZENEPOMMESMITSALZ = registerItem("versalzenepommesmitsalz");
    public static final Item SEMMELKNODELTEIG = registerItem("semmelknodelteig");
    public static final Item BRATEN = registerItem("braten");
    public static final Item BRATENROH = registerItem("bratenroh");
    public static final Item SCHWEINEHACKFLEISCH = registerItem("schweinehackfleisch");
    public static final Item HAHNCHENHACKFLEISCH = registerItem("hahnchenhackfleisch");
    public static final Item RINDERHACKFLEISCH = registerItem("rinderhackfleisch");
    public static final Item HAHNCHENPATTYROH = registerItem("hahnchenpattyroh");
    public static final Item RINDERPATTYROH = registerItem("rinderpattyroh");
    public static final Item SCHWEINEPATTYROH = registerItem("schweinepattyroh");
    public static final Item HAHNCHENPATTY = registerItem("hahnchenpatty");
    public static final Item RINDERPATTY = registerItem("rinderpatty");
    public static final Item SCHWEINEPATTY = registerItem("schweinepatty");
    public static final Item SCHWEINEBURGER = registerItem("schweineburger");
    public static final Item HAHNCHENBURGER = registerItem("hahnchenburger");
    public static final Item RINDERBURGER = registerItem("rinderburger");
    public static final Item TOMATE = registerItem("tomate");
    public static final Item SALAT = registerItem("salat");
    public static final Item ZWIEBEL = registerItem("zwiebel");
    public static final Item ZWIEBELGESCHNITTEN = registerItem("zwiebelgeschnitten");

    public static final Item LOWENZAHN = registerItem("lowenzahn");
    public static final Item MESSER = registerItem("messer");
    public static final Item TEIGROLLER = registerItem("teigroller");
     */

    public static Item registerItem(String name) {
        return Registry.register(Registry.ITEM, new Identifier(BayernMod.MOD_ID, name), new Item(new Item.Settings().group(BayernMod.ITEM_GROUP)));
    }

    public static Item registerFoodItem(Item.Settings settings, String name) {
        return Registry.register(Registry.ITEM, new Identifier(BayernMod.MOD_ID, name), new Item(settings.group(BayernMod.ITEM_GROUP)));
    }
}
