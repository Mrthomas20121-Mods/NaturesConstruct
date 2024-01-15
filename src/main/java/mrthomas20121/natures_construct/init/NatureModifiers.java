package mrthomas20121.natures_construct.init;

import mrthomas20121.natures_construct.NaturesConstruct;
import mrthomas20121.natures_construct.modifier.*;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class NatureModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(NaturesConstruct.MOD_ID);

    public static StaticModifier<AuraModifier> aura = MODIFIERS.register("aura", AuraModifier::new);

    public static StaticModifier<InfusedModifier> infused = MODIFIERS.register("infused", InfusedModifier::new);

    public static StaticModifier<MobAuraModifier> mob_aura = MODIFIERS.register("mob_aura", MobAuraModifier::new);

    public static StaticModifier<AuraCacheModifier> aura_cache = MODIFIERS.register("aura_cache", AuraCacheModifier::new);

    public static StaticModifier<HellishRepairModifier> hellish_repair = MODIFIERS.register("hellish_repair", HellishRepairModifier::new);
}
