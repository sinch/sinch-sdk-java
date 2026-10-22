package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Sinch Voice Name to use for text-to-speech. Each voice is tied to a specific language variant,
 * gender, and pricing model (Free/Standard or Paid/Generative). See <a
 * href="https://developers.sinch.com/docs/voice-2.0/api-reference/text-to-speech-voices">the
 * text-to-speech voices</a> for details
 */
public class VoiceName extends EnumDynamic<String, VoiceName> {

  /** Male voice for Hindi (India) (Free voice) */
  public static final VoiceName AARAV = new VoiceName("Aarav");

  /** Male voice for English (India) (Free voice) */
  public static final VoiceName AARAV_2 = new VoiceName("Aarav_2");

  /** Female voice for Marathi (India) (Free voice) */
  public static final VoiceName AAROHI = new VoiceName("Aarohi");

  /** Female voice for Hindi (India) (Free voice) */
  public static final VoiceName AARTI = new VoiceName("Aarti");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName AARTI_2 = new VoiceName("Aarti_2");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName AARTI_3 = new VoiceName("Aarti_3");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName AASHI = new VoiceName("Aashi");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName ABBI = new VoiceName("Abbi");

  /** Male voice for Arabic (Oman) (Free voice) */
  public static final VoiceName ABDULLAH = new VoiceName("Abdullah");

  /** Male voice for English (Nigeria) (Free voice) */
  public static final VoiceName ABEO = new VoiceName("Abeo");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName ABRIL = new VoiceName("Abril");

  /** Female voice for Thai (Thailand) (Free voice) */
  public static final VoiceName ACHARA = new VoiceName("Achara");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName ADA = new VoiceName("Ada");

  /** Female voice for English (United Kingdom) (Paid voice) */
  public static final VoiceName ADA_2 = new VoiceName("Ada_2");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName ADAM = new VoiceName("Adam");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName ADAM_2 = new VoiceName("Adam_2");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName ADITI = new VoiceName("Aditi");

  /** Female voice for Afrikaans (South Africa) (Free voice) */
  public static final VoiceName ADRI = new VoiceName("Adri");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName ADRIANO = new VoiceName("Adriano");

  /** Female voice for Polish (Poland) (Free voice) */
  public static final VoiceName AGNIESZKA = new VoiceName("Agnieszka");

  /** Male voice for Turkish (Türkiye) (Free voice) */
  public static final VoiceName AHMET = new VoiceName("Ahmet");

  /** Female voice for Kazakh (Kazakhstan) (Free voice) */
  public static final VoiceName AIGUL = new VoiceName("Aigul");

  /** Female voice for Basque (Free voice) */
  public static final VoiceName AINHOA = new VoiceName("Ainhoa");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName ALAIN = new VoiceName("Alain");

  /** Female voice for Catalan (Free voice) */
  public static final VoiceName ALBA = new VoiceName("Alba");

  /** Male voice for Welsh (United Kingdom) (Free voice) */
  public static final VoiceName ALED = new VoiceName("Aled");

  /** Male voice for Macedonian (North Macedonia) (Free voice) */
  public static final VoiceName ALEKSANDAR = new VoiceName("Aleksandar");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName ALESSIO = new VoiceName("Alessio");

  /** Male voice for Italian (Italy) (Paid voice) */
  public static final VoiceName ALESSIO_2 = new VoiceName("Alessio_2");

  /** Male voice for Spanish (Peru) (Free voice) */
  public static final VoiceName ALEX = new VoiceName("Alex");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName ALFIE = new VoiceName("Alfie");

  /** Male voice for Arabic (Bahrain) (Free voice) */
  public static final VoiceName ALI = new VoiceName("Ali");

  /** Female voice for Romanian (Romania) (Free voice) */
  public static final VoiceName ALINA = new VoiceName("Alina");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName ALLOY = new VoiceName("Alloy");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName ALLOY_2 = new VoiceName("Alloy_2");

  /** Male voice for Spanish (United States) (Free voice) */
  public static final VoiceName ALONSO = new VoiceName("Alonso");

  /** Male voice for Spanish (Spain) (Free voice) */
  public static final VoiceName ALVARO = new VoiceName("Alvaro");

  /** Female voice for Arabic (Qatar) (Free voice) */
  public static final VoiceName AMAL = new VoiceName("Amal");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName AMALA = new VoiceName("Amala");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName AMANDA = new VoiceName("Amanda");

  /** Female voice for Arabic (Syria) (Free voice) */
  public static final VoiceName AMANY = new VoiceName("Amany");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName AMBER = new VoiceName("Amber");

  /** Female voice for French (France) (Paid voice) */
  public static final VoiceName AMBRE = new VoiceName("Ambre");

  /** Male voice for Amharic (Ethiopia) (Free voice) */
  public static final VoiceName AMEHA = new VoiceName("Ameha");

  /** Female voice for Arabic (Algeria) (Free voice) */
  public static final VoiceName AMINA = new VoiceName("Amina");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName AMY = new VoiceName("Amy");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName AMY_2 = new VoiceName("Amy_2");

  /** Female voice for English (United Kingdom) (Paid voice) */
  public static final VoiceName AMY_3 = new VoiceName("Amy_3");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName ANA = new VoiceName("Ana");

  /** Female voice for Armenian (Armenia) (Free voice) */
  public static final VoiceName ANAHIT = new VoiceName("Anahit");

  /** Female voice for Hindi (India) (Free voice) */
  public static final VoiceName ANANYA = new VoiceName("Ananya");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName ANANYA_2 = new VoiceName("Ananya_2");

  /** Male voice for Tamil (Singapore) (Free voice) */
  public static final VoiceName ANBU = new VoiceName("Anbu");

  /** Male voice for Basque (Free voice) */
  public static final VoiceName ANDER = new VoiceName("Ander");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName ANDRE = new VoiceName("Andre");

  /** Male voice for Spanish (Mexico) (Paid voice) */
  public static final VoiceName ANDRE_2 = new VoiceName("Andre_2");

  /** Female voice for Spanish (Ecuador) (Free voice) */
  public static final VoiceName ANDREA = new VoiceName("Andrea");

  /** Male voice for Spanish (Guatemala) (Free voice) */
  public static final VoiceName ANDRES = new VoiceName("Andres");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName ANDREW = new VoiceName("Andrew");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName ANDREW_2 = new VoiceName("Andrew_2");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName ANDREW_3 = new VoiceName("Andrew_3");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName ANDREW_4 = new VoiceName("Andrew_4");

  /** Male voice for Filipino (Philippines) (Free voice) */
  public static final VoiceName ANGELO = new VoiceName("Angelo");

  /** Female voice for Albanian (Albania) (Free voice) */
  public static final VoiceName ANILA = new VoiceName("Anila");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName ANNETTE = new VoiceName("Annette");

  /** Male voice for French (Canada) (Free voice) */
  public static final VoiceName ANTOINE = new VoiceName("Antoine");

  /** Male voice for Czech (Czechia) (Free voice) */
  public static final VoiceName ANTONIN = new VoiceName("Antonin");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName ANTONIO = new VoiceName("Antonio");

  /** Female voice for Estonian (Estonia) (Free voice) */
  public static final VoiceName ANU = new VoiceName("Anu");

  /** Female voice for Japanese (Japan) (Free voice) */
  public static final VoiceName AOI = new VoiceName("Aoi");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName ARABELLA = new VoiceName("Arabella");

  /** Male voice for Indonesian (Indonesia) (Free voice) */
  public static final VoiceName ARDI = new VoiceName("Ardi");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName ARIA = new VoiceName("Aria");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName ARIA_2 = new VoiceName("Aria_2");

  /** Female voice for French (Switzerland) (Free voice) */
  public static final VoiceName ARIANE = new VoiceName("Ariane");

  /** Male voice for English (India) (Free voice) */
  public static final VoiceName ARJUN = new VoiceName("Arjun");

  /** Male voice for English (India) (Free voice) */
  public static final VoiceName ARJUN_2 = new VoiceName("Arjun_2");

  /** Male voice for Hindi (India) (Free voice) */
  public static final VoiceName ARJUN_3 = new VoiceName("Arjun_3");

  /** Female voice for Catalan (Free voice) */
  public static final VoiceName ARLET = new VoiceName("Arlet");

  /** Male voice for Spanish (Spain) (Free voice) */
  public static final VoiceName ARNAU = new VoiceName("Arnau");

  /** Male voice for Dutch (Belgium) (Free voice) */
  public static final VoiceName ARNAUD = new VoiceName("Arnaud");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName ARTHUR = new VoiceName("Arthur");

  /** Female voice for English (New Zealand) (Free voice) */
  public static final VoiceName ARYA = new VoiceName("Arya");

  /** Female voice for English (New Zealand) (Paid voice) */
  public static final VoiceName ARYA_2 = new VoiceName("Arya_2");

  /** Male voice for Urdu (Pakistan) (Free voice) */
  public static final VoiceName ASAD = new VoiceName("Asad");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName ASHLEY = new VoiceName("Ashley");

  /** Female voice for English (Kenya) (Free voice) */
  public static final VoiceName ASILIA = new VoiceName("Asilia");

  /** Female voice for Swedish (Sweden) (Free voice) */
  public static final VoiceName ASTRID = new VoiceName("Astrid");

  /** Female voice for Greek (Greece) (Free voice) */
  public static final VoiceName ATHINA = new VoiceName("Athina");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName AVA = new VoiceName("Ava");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName AVA_2 = new VoiceName("Ava_2");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName AVA_3 = new VoiceName("Ava_3");

  /** Male voice for Hebrew (Israel) (Free voice) */
  public static final VoiceName AVRI = new VoiceName("Avri");

  /** Female voice for English (South Africa) (Free voice) */
  public static final VoiceName AYANDA = new VoiceName("Ayanda");

  /** Female voice for English (South Africa) (Paid voice) */
  public static final VoiceName AYANDA_2 = new VoiceName("Ayanda_2");

  /** Female voice for Arabic (Oman) (Free voice) */
  public static final VoiceName AYSHA = new VoiceName("Aysha");

  /** Male voice for Azerbaijani (Latin, Azerbaijan) (Free voice) */
  public static final VoiceName BABEK = new VoiceName("Babek");

  /** Female voice for Azerbaijani (Latin, Azerbaijan) (Free voice) */
  public static final VoiceName BANU = new VoiceName("Banu");

  /** Male voice for Bengali (India) (Free voice) */
  public static final VoiceName BASHKAR = new VoiceName("Bashkar");

  /** Male voice for Arabic (Iraq) (Free voice) */
  public static final VoiceName BASSEL = new VoiceName("Bassel");

  /** Male voice for Mongolian (Mongolia) (Free voice) */
  public static final VoiceName BATAA = new VoiceName("Bataa");

  /** Female voice for Italian (Italy) (Paid voice) */
  public static final VoiceName BEATRICE = new VoiceName("Beatrice");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName BEATRIZ = new VoiceName("Beatriz");

  /** Female voice for Spanish (Cuba) (Free voice) */
  public static final VoiceName BELKYS = new VoiceName("Belkys");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName BELLA = new VoiceName("Bella");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName BENIGNO = new VoiceName("Benigno");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName BERND = new VoiceName("Bernd");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName BIANCA = new VoiceName("Bianca");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName BIANCA_2 = new VoiceName("Bianca_2");

  /** Female voice for Italian (Italy) (Paid voice) */
  public static final VoiceName BIANCA_3 = new VoiceName("Bianca_3");

  /** Female voice for Filipino (Philippines) (Free voice) */
  public static final VoiceName BLESSICA = new VoiceName("Blessica");

  /** Male voice for Korean (Korea) (Free voice) */
  public static final VoiceName BONG_JIN = new VoiceName("BongJin");

  /** Male voice for Bulgarian (Bulgaria) (Free voice) */
  public static final VoiceName BORISLAV = new VoiceName("Borislav");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName BRANDON = new VoiceName("Brandon");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName BRANDON_2 = new VoiceName("Brandon_2");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName BREE = new VoiceName("Bree");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName BRENDA = new VoiceName("Brenda");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName BRIAN = new VoiceName("Brian");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName BRIAN_2 = new VoiceName("Brian_2");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName BRIAN_3 = new VoiceName("Brian_3");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName BRIGITTE = new VoiceName("Brigitte");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName BRYAN = new VoiceName("Bryan");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName BRYAN_2 = new VoiceName("Bryan_2");

  /** Male voice for English (United Kingdom) (Paid voice) */
  public static final VoiceName BRYAN_3 = new VoiceName("Bryan_3");

  /** Female voice for Turkish (Türkiye) (Free voice) */
  public static final VoiceName BURCU = new VoiceName("Burcu");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName CALIMERO = new VoiceName("Calimero");

  /** Female voice for Spanish (Peru) (Free voice) */
  public static final VoiceName CAMILA = new VoiceName("Camila");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName CAMILLA = new VoiceName("Camilla");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName CAMILLA_2 = new VoiceName("Camilla_2");

  /** Female voice for Portuguese (Brazil) (Paid voice) */
  public static final VoiceName CAMILLA_3 = new VoiceName("Camilla_3");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName CANDELA = new VoiceName("Candela");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName CARLA = new VoiceName("Carla");

  /** Male voice for Spanish (Honduras) (Free voice) */
  public static final VoiceName CARLOS = new VoiceName("Carlos");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName CARLOTA = new VoiceName("Carlota");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName CARLY = new VoiceName("Carly");

  /** Female voice for Romanian (Romania) (Free voice) */
  public static final VoiceName CARMEN = new VoiceName("Carmen");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName CATALDO = new VoiceName("Cataldo");

  /** Female voice for Spanish (Chile) (Free voice) */
  public static final VoiceName CATALINA = new VoiceName("Catalina");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName CECILIO = new VoiceName("Cecilio");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName CELESTE = new VoiceName("Celeste");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName CELINE = new VoiceName("Celine");

  /** Female voice for French (France) (Paid voice) */
  public static final VoiceName CELINE_2 = new VoiceName("Celine_2");

  /** Female voice for French (Canada) (Free voice) */
  public static final VoiceName CHANTAL = new VoiceName("Chantal");

  /** Male voice for Lao (Laos) (Free voice) */
  public static final VoiceName CHANTHAVONG = new VoiceName("Chanthavong");

  /** Female voice for French (Belgium) (Free voice) */
  public static final VoiceName CHARLINE = new VoiceName("Charline");

  /** Male voice for English (Kenya) (Free voice) */
  public static final VoiceName CHILEMBA = new VoiceName("Chilemba");

  /** Female voice for Danish (Denmark) (Free voice) */
  public static final VoiceName CHRISTEL = new VoiceName("Christel");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName CHRISTOPH = new VoiceName("Christoph");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName CHRISTOPHER = new VoiceName("Christopher");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName CHRISTOPHER_2 = new VoiceName("Christopher_2");

  /** Female voice for English (Canada) (Free voice) */
  public static final VoiceName CLARA = new VoiceName("Clara");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName CLAUDE = new VoiceName("Claude");

  /** Female voice for Dutch (Netherlands) (Free voice) */
  public static final VoiceName COLETTE = new VoiceName("Colette");

  /** Male voice for Irish (Ireland) (Free voice) */
  public static final VoiceName COLM = new VoiceName("Colm");

  /** Female voice for Spanish (Castilian) (Free voice) */
  public static final VoiceName CONCHITA = new VoiceName("Conchita");

  /** Male voice for English (Ireland) (Free voice) */
  public static final VoiceName CONNOR = new VoiceName("Connor");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName CONRAD = new VoiceName("Conrad");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName CORA = new VoiceName("Cora");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName CORA_2 = new VoiceName("Cora_2");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName CORALIE = new VoiceName("Coralie");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName CRISTIANO = new VoiceName("Cristiano");

  /** Male voice for Japanese (Japan) (Free voice) */
  public static final VoiceName DAICHI = new VoiceName("Daichi");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName DALIA = new VoiceName("Dalia");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName DALIA_2 = new VoiceName("Dalia_2");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName DANIEL = new VoiceName("Daniel");

  /** Male voice for German (Germany) (Paid voice) */
  public static final VoiceName DANIEL_2 = new VoiceName("Daniel_2");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName DANIELLE = new VoiceName("Danielle");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName DANIELLE_2 = new VoiceName("Danielle_2");

  /** Male voice for Spanish (Spain) (Free voice) */
  public static final VoiceName DARIO = new VoiceName("Dario");

  /** Female voice for Russian (Russia) (Free voice) */
  public static final VoiceName DARIYA = new VoiceName("Dariya");

  /** Male voice for English (Australia) (Free voice) */
  public static final VoiceName DARREN = new VoiceName("Darren");

  /** Male voice for Swahili (Tanzania) (Free voice) */
  public static final VoiceName DAUDI = new VoiceName("Daudi");

  /** Male voice for Kazakh (Kazakhstan) (Free voice) */
  public static final VoiceName DAULET = new VoiceName("Daulet");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName DAVIS = new VoiceName("Davis");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName DAVIS_2 = new VoiceName("Davis_2");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName DAVIS_3 = new VoiceName("Davis_3");

  /** Female voice for Dutch (Belgium) (Free voice) */
  public static final VoiceName DENA = new VoiceName("Dena");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName DENISE = new VoiceName("Denise");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName DEREK = new VoiceName("Derek");

  /** Female voice for Gujarati (India) (Free voice) */
  public static final VoiceName DHWANI = new VoiceName("Dhwani");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName DIEGO = new VoiceName("Diego");

  /** Female voice for Persian (Iran) (Free voice) */
  public static final VoiceName DILARA = new VoiceName("Dilara");

  /** Male voice for Javanese (Latin, Indonesia) (Free voice) */
  public static final VoiceName DIMAS = new VoiceName("Dimas");

  /** Male voice for Russian (Russia) (Free voice) */
  public static final VoiceName DMITRY = new VoiceName("Dmitry");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName DONATO = new VoiceName("Donato");

  /** Female voice for Icelandic (Iceland) (Free voice) */
  public static final VoiceName DORA = new VoiceName("Dora");

  /** Male voice for Portuguese (Portugal) (Free voice) */
  public static final VoiceName DUARTE = new VoiceName("Duarte");

  /** Male voice for English (Australia) (Free voice) */
  public static final VoiceName DUNCAN = new VoiceName("Duncan");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName DUSTIN = new VoiceName("Dustin");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName ECHO = new VoiceName("Echo");

  /** Female voice for Georgian (Georgia) (Free voice) */
  public static final VoiceName EKA = new VoiceName("Eka");

  /** Female voice for Spanish (Argentina) (Free voice) */
  public static final VoiceName ELENA = new VoiceName("Elena");

  /** Male voice for Spanish (Spain) (Free voice) */
  public static final VoiceName ELIAS = new VoiceName("Elias");

  /** Male voice for English (Tanzania) (Free voice) */
  public static final VoiceName ELIMU = new VoiceName("Elimu");

  /** Female voice for Swedish (Sweden) (Free voice) */
  public static final VoiceName ELIN = new VoiceName("Elin");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName ELIZABETH = new VoiceName("Elizabeth");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName ELKE = new VoiceName("Elke");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName ELLIOT = new VoiceName("Elliot");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName ELOISE = new VoiceName("Eloise");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName ELSA = new VoiceName("Elsa");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName ELSIE = new VoiceName("Elsie");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName ELVIRA = new VoiceName("Elvira");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName ELZA = new VoiceName("Elza");

  /** Female voice for Turkish (Türkiye) (Free voice) */
  public static final VoiceName EMEL = new VoiceName("Emel");

  /** Male voice for Romanian (Romania) (Free voice) */
  public static final VoiceName EMIL = new VoiceName("Emil");

  /** Male voice for Spanish (Dominican Republic) (Free voice) */
  public static final VoiceName EMILIO = new VoiceName("Emilio");

  /** Female voice for English (Ireland) (Free voice) */
  public static final VoiceName EMILY = new VoiceName("Emily");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName EMMA = new VoiceName("Emma");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName EMMA_2 = new VoiceName("Emma_2");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName EMMA_3 = new VoiceName("Emma_3");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName EMMA_4 = new VoiceName("Emma_4");

  /** Male voice for Catalan (Free voice) */
  public static final VoiceName ENRIC = new VoiceName("Enric");

  /** Male voice for Spanish (Castilian) (Free voice) */
  public static final VoiceName ENRIQUE = new VoiceName("Enrique");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName ERIC = new VoiceName("Eric");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName ESTRELLA = new VoiceName("Estrella");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName ETHAN = new VoiceName("Ethan");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName EVELYN = new VoiceName("Evelyn");

  /** Female voice for Latvian (Latvia) (Free voice) */
  public static final VoiceName EVERITA = new VoiceName("Everita");

  /** Female voice for Polish (Poland) (Free voice) */
  public static final VoiceName EWA = new VoiceName("Ewa");

  /** Female voice for Polish (Poland) (Paid voice) */
  public static final VoiceName EWA_2 = new VoiceName("Ewa_2");

  /** Female voice for English (Nigeria) (Free voice) */
  public static final VoiceName EZINNE = new VoiceName("Ezinne");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName FABIO = new VoiceName("Fabio");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName FABIOLA = new VoiceName("Fabiola");

  /** Neutral voice for English (United States) (Free voice) */
  public static final VoiceName FABLE = new VoiceName("Fable");

  /** Male voice for French (Switzerland) (Free voice) */
  public static final VoiceName FABRICE = new VoiceName("Fabrice");

  /** Male voice for Arabic (Kuwait) (Free voice) */
  public static final VoiceName FAHED = new VoiceName("Fahed");

  /** Male voice for Persian (Iran) (Free voice) */
  public static final VoiceName FARID = new VoiceName("Farid");

  /** Female voice for Arabic (United Arab Emirates) (Free voice) */
  public static final VoiceName FATIMA = new VoiceName("Fatima");

  /** Male voice for Spanish (Nicaragua) (Free voice) */
  public static final VoiceName FEDERICO = new VoiceName("Federico");

  /** Female voice for Dutch (Netherlands) (Free voice) */
  public static final VoiceName FENNA = new VoiceName("Fenna");

  /** Female voice for Portuguese (Portugal) (Free voice) */
  public static final VoiceName FERNANDA = new VoiceName("Fernanda");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName FIAMMA = new VoiceName("Fiamma");

  /** Female voice for Turkish (Türkiye) (Free voice) */
  public static final VoiceName FILIZ = new VoiceName("Filiz");

  /** Male voice for Norwegian (Norway) (Free voice) */
  public static final VoiceName FINN = new VoiceName("Finn");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName FLORIAN = new VoiceName("Florian");

  /** Male voice for German (Germany) (Paid voice) */
  public static final VoiceName FLORIAN_2 = new VoiceName("Florian_2");

  /** Male voice for French (France) (Paid voice) */
  public static final VoiceName FLORIN = new VoiceName("Florin");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName FRANCISCA = new VoiceName("Francisca");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName FREYA = new VoiceName("Freya");

  /** Female voice for French (Canada) (Free voice) */
  public static final VoiceName GABRIELLE = new VoiceName("Gabrielle");

  /** Female voice for French (Canada) (Paid voice) */
  public static final VoiceName GABRIELLE_2 = new VoiceName("Gabrielle_2");

  /** Female voice for Croatian (Croatia) (Free voice) */
  public static final VoiceName GABRIJELA = new VoiceName("Gabrijela");

  /** Female voice for Indonesian (Indonesia) (Free voice) */
  public static final VoiceName GADIS = new VoiceName("Gadis");

  /** Male voice for Kannada (India) (Free voice) */
  public static final VoiceName GAGAN = new VoiceName("Gagan");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName GEMMA = new VoiceName("Gemma");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName GEMMA_2 = new VoiceName("Gemma_2");

  /** Male voice for Welsh (United Kingdom) (Free voice) */
  public static final VoiceName GERAINT = new VoiceName("Geraint");

  /** Male voice for French (Belgium) (Free voice) */
  public static final VoiceName GERARD = new VoiceName("Gerard");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName GERARDO = new VoiceName("Gerardo");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName GIANNI = new VoiceName("Gianni");

  /** Male voice for Georgian (Georgia) (Free voice) */
  public static final VoiceName GIORGI = new VoiceName("Giorgi");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName GIORGIO = new VoiceName("Giorgio");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName GIOVANNA = new VoiceName("Giovanna");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName GISELA = new VoiceName("Gisela");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName GIUSEPPE = new VoiceName("Giuseppe");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName GIUSEPPE_2 = new VoiceName("Giuseppe_2");

  /** Male voice for Spanish (Colombia) (Free voice) */
  public static final VoiceName GONZALO = new VoiceName("Gonzalo");

  /** Male voice for Korean (Korea) (Free voice) */
  public static final VoiceName GOOK_MIN = new VoiceName("GookMin");

  /** Male voice for Bosnian (Bosnia and Herzegovina) (Free voice) */
  public static final VoiceName GORAN = new VoiceName("Goran");

  /** Female voice for Maltese (Malta) (Free voice) */
  public static final VoiceName GRACE = new VoiceName("Grace");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName GREGORY = new VoiceName("Gregory");

  /** Female voice for Icelandic (Iceland) (Free voice) */
  public static final VoiceName GUDRUN = new VoiceName("Gudrun");

  /** Female voice for Urdu (India) (Free voice) */
  public static final VoiceName GUL = new VoiceName("Gul");

  /** Male voice for Pashto (Afghanistan) (Free voice) */
  public static final VoiceName GUL_NAWAZ = new VoiceName("GulNawaz");

  /** Male voice for Icelandic (Iceland) (Free voice) */
  public static final VoiceName GUNNAR = new VoiceName("Gunnar");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName GUY = new VoiceName("Guy");

  /** Female voice for Welsh (United Kingdom) (Free voice) */
  public static final VoiceName GWYNETH = new VoiceName("Gwyneth");

  /** Female voice for Arabic (Saudi Arabia) (Free voice) */
  public static final VoiceName HALA = new VoiceName("Hala");

  /** Male voice for Arabic (United Arab Emirates) (Free voice) */
  public static final VoiceName HAMDAN = new VoiceName("Hamdan");

  /** Male voice for Arabic (Saudi Arabia) (Free voice) */
  public static final VoiceName HAMED = new VoiceName("Hamed");

  /** Female voice for German (Austria) (Free voice) */
  public static final VoiceName HANNAH = new VoiceName("Hannah");

  /** Female voice for German (Austria) (Paid voice) */
  public static final VoiceName HANNAH_2 = new VoiceName("Hannah_2");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName HANS = new VoiceName("Hans");

  /** Male voice for Finnish (Finland) (Free voice) */
  public static final VoiceName HARRI = new VoiceName("Harri");

  /** Male voice for Armenian (Armenia) (Free voice) */
  public static final VoiceName HAYK = new VoiceName("Hayk");

  /** Male voice for Arabic (Tunisia) (Free voice) */
  public static final VoiceName HEDI = new VoiceName("Hedi");

  /** Female voice for Nepali (Nepal) (Free voice) */
  public static final VoiceName HEMKALA = new VoiceName("Hemkala");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName HENRI = new VoiceName("Henri");

  /** Female voice for Hebrew (Israel) (Free voice) */
  public static final VoiceName HILA = new VoiceName("Hila");

  /** Female voice for Swedish (Sweden) (Free voice) */
  public static final VoiceName HILLEVI = new VoiceName("Hillevi");

  /** Female voice for Chinese (Cantonese, Traditional) (Free voice) */
  public static final VoiceName HIU_GAAI = new VoiceName("HiuGaai");

  /** Female voice for Chinese (Cantonese) (Free voice) */
  public static final VoiceName HIUJIN = new VoiceName("Hiujin");

  /** Female voice for Chinese (Cantonese, Traditional) (Free voice) */
  public static final VoiceName HIU_MAAN = new VoiceName("HiuMaan");

  /** Female voice for Vietnamese (Vietnam) (Free voice) */
  public static final VoiceName HOAI_MY = new VoiceName("HoaiMy");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName HOLLIE = new VoiceName("Hollie");

  /** Female voice for Chinese (Taiwanese Mandarin, Traditional) (Free voice) */
  public static final VoiceName HSIAO_CHEN = new VoiceName("HsiaoChen");

  /** Female voice for Chinese (Taiwanese Mandarin, Traditional) (Free voice) */
  public static final VoiceName HSIAO_YU = new VoiceName("HsiaoYu");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName HUMBERTO = new VoiceName("Humberto");

  /** Male voice for Korean (Korea) (Free voice) */
  public static final VoiceName HYUNSU = new VoiceName("Hyunsu");

  /** Male voice for Korean (Korea) (Free voice) */
  public static final VoiceName HYUNSU_2 = new VoiceName("Hyunsu_2");

  /** Male voice for Korean (Korea) (Paid voice) */
  public static final VoiceName HYUNSU_3 = new VoiceName("Hyunsu_3");

  /** Female voice for Norwegian (Norway) (Free voice) */
  public static final VoiceName IDA = new VoiceName("Ida");

  /** Male voice for Albanian (Albania) (Free voice) */
  public static final VoiceName ILIR = new VoiceName("Ilir");

  /** Female voice for Arabic (Libya) (Free voice) */
  public static final VoiceName IMAN = new VoiceName("Iman");

  /** Female voice for English (Tanzania) (Free voice) */
  public static final VoiceName IMANI = new VoiceName("Imani");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName IMELDA = new VoiceName("Imelda");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName INES = new VoiceName("Ines");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName INES_2 = new VoiceName("Ines_2");

  /** Female voice for German (Austria) (Free voice) */
  public static final VoiceName INGRID = new VoiceName("Ingrid");

  /** Male voice for Korean (Korea) (Free voice) */
  public static final VoiceName IN_JOON = new VoiceName("InJoon");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName IRENE = new VoiceName("Irene");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName IRMA = new VoiceName("Irma");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName ISABELLA = new VoiceName("Isabella");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName ISABELLA_2 = new VoiceName("Isabella_2");

  /** Female voice for Italian (Italy) (Paid voice) */
  public static final VoiceName ISABELLA_3 = new VoiceName("Isabella_3");

  /** Female voice for French (Belgium) (Free voice) */
  public static final VoiceName ISABELLE = new VoiceName("Isabelle");

  /** Female voice for French (Belgium) (Paid voice) */
  public static final VoiceName ISABELLE_2 = new VoiceName("Isabelle_2");

  /** Female voice for Norwegian (Norway) (Free voice) */
  public static final VoiceName ISELIN = new VoiceName("Iselin");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName ISIDORA = new VoiceName("Isidora");

  /** Male voice for Arabic (Algeria) (Free voice) */
  public static final VoiceName ISMAEL = new VoiceName("Ismael");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName IVY = new VoiceName("Ivy");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName IVY_2 = new VoiceName("Ivy_2");

  /** Male voice for Polish (Poland) (Free voice) */
  public static final VoiceName JACEK = new VoiceName("Jacek");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName JACOB = new VoiceName("Jacob");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName JACQUELINE = new VoiceName("Jacqueline");

  /** Male voice for Sundanese (Indonesia) (Free voice) */
  public static final VoiceName JAJANG = new VoiceName("Jajang");

  /** Male voice for Arabic (Morocco) (Free voice) */
  public static final VoiceName JAMAL = new VoiceName("Jamal");

  /** Male voice for English (Philippines) (Free voice) */
  public static final VoiceName JAMES = new VoiceName("James");

  /** Male voice for German (Switzerland) (Free voice) */
  public static final VoiceName JAN = new VoiceName("Jan");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName JANE = new VoiceName("Jane");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName JANE_2 = new VoiceName("Jane_2");

  /** Male voice for Polish (Poland) (Free voice) */
  public static final VoiceName JANN = new VoiceName("Jann");

  /** Female voice for English (Singapore) (Free voice) */
  public static final VoiceName JASMINE = new VoiceName("Jasmine");

  /** Female voice for English (Singapore) (Paid voice) */
  public static final VoiceName JASMINE_2 = new VoiceName("Jasmine_2");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName JASON = new VoiceName("Jason");

  /** Male voice for Spanish (Equatorial Guinea) (Free voice) */
  public static final VoiceName JAVIER = new VoiceName("Javier");

  /** Male voice for French (Canada) (Free voice) */
  public static final VoiceName JEAN = new VoiceName("Jean");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName JENNY = new VoiceName("Jenny");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName JENNY_2 = new VoiceName("Jenny_2");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName JENNY_3 = new VoiceName("Jenny_3");

  /** Male voice for Danish (Denmark) (Free voice) */
  public static final VoiceName JEPPE = new VoiceName("Jeppe");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName JEROME = new VoiceName("Jerome");

  /** Female voice for Korean (Korea) (Free voice) */
  public static final VoiceName JIHYE = new VoiceName("Jihye");

  /** Female voice for Korean (Korea) (Free voice) */
  public static final VoiceName JI_MIN = new VoiceName("JiMin");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName JIMMIE = new VoiceName("Jimmie");

  /** Female voice for Czech (Czechia) (Free voice) */
  public static final VoiceName JITKA = new VoiceName("Jitka");

  /** Female voice for Catalan (Free voice) */
  public static final VoiceName JOANA = new VoiceName("Joana");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName JOANNA = new VoiceName("Joanna");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName JOANNA_2 = new VoiceName("Joanna_2");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName JOANNA_3 = new VoiceName("Joanna_3");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName JOANNE = new VoiceName("Joanne");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName JOEY = new VoiceName("Joey");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName JOEY_2 = new VoiceName("Joey_2");

  /** Male voice for German (Austria) (Free voice) */
  public static final VoiceName JONAS = new VoiceName("Jonas");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName JORGE = new VoiceName("Jorge");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName JORGE_2 = new VoiceName("Jorge_2");

  /** Male voice for Maltese (Malta) (Free voice) */
  public static final VoiceName JOSEPH = new VoiceName("Joseph");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName JOSEPHINE = new VoiceName("Josephine");

  /** Male voice for Spanish (Costa Rica) (Free voice) */
  public static final VoiceName JUAN = new VoiceName("Juan");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName JULIO = new VoiceName("Julio");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName JUSTIN = new VoiceName("Justin");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName JUSTIN_2 = new VoiceName("Justin_2");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName KAI = new VoiceName("Kai");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName KAJAL = new VoiceName("Kajal");

  /** Female voice for English (India) (Paid voice) */
  public static final VoiceName KAJAL_2 = new VoiceName("Kajal_2");

  /** Female voice for Bulgarian (Bulgaria) (Free voice) */
  public static final VoiceName KALINA = new VoiceName("Kalina");

  /** Female voice for Tamil (Malaysia) (Free voice) */
  public static final VoiceName KANI = new VoiceName("Kani");

  /** Female voice for Spanish (Puerto Rico) (Free voice) */
  public static final VoiceName KARINA = new VoiceName("Karina");

  /** Male voice for Icelandic (Iceland) (Free voice) */
  public static final VoiceName KARL = new VoiceName("Karl");

  /** Female voice for Spanish (Honduras) (Free voice) */
  public static final VoiceName KARLA = new VoiceName("Karla");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName KASPER = new VoiceName("Kasper");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName KATJA = new VoiceName("Katja");

  /** Female voice for Hindi (India) (Free voice) */
  public static final VoiceName KAVYA = new VoiceName("Kavya");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName KAVYA_2 = new VoiceName("Kavya_2");

  /** Female voice for Japanese (Japan) (Free voice) */
  public static final VoiceName KAZUHA = new VoiceName("Kazuha");

  /** Male voice for Japanese (Japan) (Free voice) */
  public static final VoiceName KEITA = new VoiceName("Keita");

  /** Male voice for English (Australia) (Free voice) */
  public static final VoiceName KEN = new VoiceName("Ken");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName KENDRA = new VoiceName("Kendra");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName KENDRA_2 = new VoiceName("Kendra_2");

  /** Female voice for Lao (Laos) (Free voice) */
  public static final VoiceName KEOMANY = new VoiceName("Keomany");

  /** Male voice for Estonian (Estonia) (Free voice) */
  public static final VoiceName KERT = new VoiceName("Kert");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName KEVIN = new VoiceName("Kevin");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName KILLIAN = new VoiceName("Killian");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName KIM = new VoiceName("Kim");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName KIMBERLY = new VoiceName("Kimberly");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName KIMBERLY_2 = new VoiceName("Kimberly_2");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName KLARISSA = new VoiceName("Klarissa");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName KLAUS = new VoiceName("Klaus");

  /** Male voice for Tamil (Sri Lanka) (Free voice) */
  public static final VoiceName KUMAR = new VoiceName("Kumar");

  /** Male voice for Hindi (India) (Free voice) */
  public static final VoiceName KUNAL = new VoiceName("Kunal");

  /** Male voice for English (India) (Free voice) */
  public static final VoiceName KUNAL_2 = new VoiceName("Kunal_2");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName LAIA = new VoiceName("Laia");

  /** Female voice for Arabic (Bahrain) (Free voice) */
  public static final VoiceName LAILA = new VoiceName("Laila");

  /** Male voice for Arabic (Syria) (Free voice) */
  public static final VoiceName LAITH = new VoiceName("Laith");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName LARISSA = new VoiceName("Larissa");

  /** Female voice for Pashto (Afghanistan) (Free voice) */
  public static final VoiceName LATIFA = new VoiceName("Latifa");

  /** Female voice for Dutch (Netherlands) (Free voice) */
  public static final VoiceName LAURA = new VoiceName("Laura");

  /** Female voice for Dutch (Netherlands) (Paid voice) */
  public static final VoiceName LAURA_2 = new VoiceName("Laura_2");

  /** Female voice for Arabic (Lebanon) (Free voice) */
  public static final VoiceName LAYLA = new VoiceName("Layla");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName LEA = new VoiceName("Lea");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName LEA_2 = new VoiceName("Lea_2");

  /** Female voice for French (France) (Paid voice) */
  public static final VoiceName LEA_3 = new VoiceName("Lea_3");

  /** Female voice for English (South Africa) (Free voice) */
  public static final VoiceName LEAH = new VoiceName("Leah");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName LEILA = new VoiceName("Leila");

  /** Female voice for German (Switzerland) (Free voice) */
  public static final VoiceName LENI = new VoiceName("Leni");

  /** Male voice for German (Germany) (Paid voice) */
  public static final VoiceName LENNART = new VoiceName("Lennart");

  /** Male voice for Lithuanian (Lithuania) (Free voice) */
  public static final VoiceName LEONAS = new VoiceName("Leonas");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName LETICIA = new VoiceName("Leticia");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName LEWIS = new VoiceName("Lewis");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName LIA = new VoiceName("Lia");

  /** Male voice for English (Canada) (Free voice) */
  public static final VoiceName LIAM = new VoiceName("Liam");

  /** Male voice for French (Canada) (Free voice) */
  public static final VoiceName LIAN = new VoiceName("Lian");

  /** Male voice for French (Canada) (Paid voice) */
  public static final VoiceName LIAN_2 = new VoiceName("Lian_2");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName LIBBY = new VoiceName("Libby");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName LIBERTO = new VoiceName("Liberto");

  /** Female voice for Dutch (Belgium) (Free voice) */
  public static final VoiceName LISA = new VoiceName("Lisa");

  /** Female voice for Dutch (Belgium) (Paid voice) */
  public static final VoiceName LISA_2 = new VoiceName("Lisa_2");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName LISANDRO = new VoiceName("Lisandro");

  /** Female voice for Norwegian (Norway) (Free voice) */
  public static final VoiceName LIV = new VoiceName("Liv");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName LIVIA = new VoiceName("Livia");

  /** Female voice for English (Australia) (Paid voice) */
  public static final VoiceName LIVIA_2 = new VoiceName("Livia_2");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName LOLA = new VoiceName("Lola");

  /** Female voice for Spanish (El Salvador) (Free voice) */
  public static final VoiceName LORENA = new VoiceName("Lorena");

  /** Male voice for Italian (Italy) (Paid voice) */
  public static final VoiceName LORENZIO = new VoiceName("Lorenzio");

  /** Male voice for Spanish (Chile) (Free voice) */
  public static final VoiceName LORENZO = new VoiceName("Lorenzo");

  /** Female voice for Dutch (Netherlands) (Free voice) */
  public static final VoiceName LOTTE = new VoiceName("Lotte");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName LOUISA = new VoiceName("Louisa");

  /** Female voice for Spanish (Castilian) (Free voice) */
  public static final VoiceName LUCIA = new VoiceName("Lucia");

  /** Female voice for Spanish (Castilian) (Free voice) */
  public static final VoiceName LUCIA_2 = new VoiceName("Lucia_2");

  /** Female voice for Spanish (Castilian) (Paid voice) */
  public static final VoiceName LUCIA_3 = new VoiceName("Lucia_3");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName LUCIANO = new VoiceName("Luciano");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName LUCIEN = new VoiceName("Lucien");

  /** Male voice for Spanish (Ecuador) (Free voice) */
  public static final VoiceName LUIS = new VoiceName("Luis");

  /** Male voice for Slovak (Slovakia) (Free voice) */
  public static final VoiceName LUKAS = new VoiceName("Lukas");

  /** Male voice for English (South Africa) (Free voice) */
  public static final VoiceName LUKE = new VoiceName("Luke");

  /** Female voice for English (Singapore) (Free voice) */
  public static final VoiceName LUNA = new VoiceName("Luna");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName LUNA_2 = new VoiceName("Luna_2");

  /** Female voice for Spanish (United States) (Free voice) */
  public static final VoiceName LUPE = new VoiceName("Lupe");

  /** Female voice for Spanish (United States) (Free voice) */
  public static final VoiceName LUPE_2 = new VoiceName("Lupe_2");

  /** Female voice for Spanish (United States) (Paid voice) */
  public static final VoiceName LUPE_3 = new VoiceName("Lupe_3");

  /** Male voice for Dutch (Netherlands) (Free voice) */
  public static final VoiceName MAARTEN = new VoiceName("Maarten");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName MACERIO = new VoiceName("Macerio");

  /** Male voice for Portuguese (Brazil) (Paid voice) */
  public static final VoiceName MACERIO_2 = new VoiceName("Macerio_2");

  /** Male voice for Hindi (India) (Free voice) */
  public static final VoiceName MADHUR = new VoiceName("Madhur");

  /** Female voice for Uzbek (Latin, Uzbekistan) (Free voice) */
  public static final VoiceName MADINA = new VoiceName("Madina");

  /** Male voice for Danish (Denmark) (Free voice) */
  public static final VoiceName MADS = new VoiceName("Mads");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName MAISIE = new VoiceName("Maisie");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName MAJA = new VoiceName("Maja");

  /** Male voice for Marathi (India) (Free voice) */
  public static final VoiceName MANOHAR = new VoiceName("Manohar");

  /** Male voice for Spanish (Cuba) (Free voice) */
  public static final VoiceName MANUEL = new VoiceName("Manuel");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName MANUELA = new VoiceName("Manuela");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName MARCELLO = new VoiceName("Marcello");

  /** Male voice for Spanish (Bolivia) (Free voice) */
  public static final VoiceName MARCELO = new VoiceName("Marcelo");

  /** Male voice for Polish (Poland) (Free voice) */
  public static final VoiceName MAREK = new VoiceName("Marek");

  /** Female voice for Spanish (Panama) (Free voice) */
  public static final VoiceName MARGARITA = new VoiceName("Margarita");

  /** Female voice for Spanish (Costa Rica) (Free voice) */
  public static final VoiceName MARIA = new VoiceName("Maria");

  /** Female voice for Macedonian (North Macedonia) (Free voice) */
  public static final VoiceName MARIJA = new VoiceName("Marija");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName MARINA = new VoiceName("Marina");

  /** Male voice for Spanish (Paraguay) (Free voice) */
  public static final VoiceName MARIO = new VoiceName("Mario");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName MARLENE = new VoiceName("Marlene");

  /** Female voice for Spanish (Guatemala) (Free voice) */
  public static final VoiceName MARTA = new VoiceName("Marta");

  /** Female voice for Arabic (Yemen) (Free voice) */
  public static final VoiceName MARYAM = new VoiceName("Maryam");

  /** Male voice for Japanese (Japan) (Paid voice) */
  public static final VoiceName MASARU = new VoiceName("Masaru");

  /** Male voice for Spanish (Uruguay) (Free voice) */
  public static final VoiceName MATEO = new VoiceName("Mateo");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName MATHIEU = new VoiceName("Mathieu");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName MATTHEW = new VoiceName("Matthew");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName MATTHEW_2 = new VoiceName("Matthew_2");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName MATTHEW_3 = new VoiceName("Matthew_3");

  /** Male voice for Swedish (Sweden) (Free voice) */
  public static final VoiceName MATTIAS = new VoiceName("Mattias");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName MAURICE = new VoiceName("Maurice");

  /** Male voice for Russian (Russia) (Free voice) */
  public static final VoiceName MAXIM = new VoiceName("Maxim");

  /** Female voice for Polish (Poland) (Free voice) */
  public static final VoiceName MAYA = new VoiceName("Maya");

  /** Female voice for Japanese (Japan) (Free voice) */
  public static final VoiceName MAYU = new VoiceName("Mayu");

  /** Female voice for Amharic (Ethiopia) (Free voice) */
  public static final VoiceName MEKDES = new VoiceName("Mekdes");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName MIA = new VoiceName("Mia");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName MIA_2 = new VoiceName("Mia_2");

  /** Female voice for Spanish (Mexico) (Paid voice) */
  public static final VoiceName MIA_3 = new VoiceName("Mia_3");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName MICHELLE = new VoiceName("Michelle");

  /** Male voice for Malayalam (India) (Free voice) */
  public static final VoiceName MIDHUN = new VoiceName("Midhun");

  /** Male voice for Spanish (United States) (Free voice) */
  public static final VoiceName MIGUEL = new VoiceName("Miguel");

  /** Male voice for English (New Zealand) (Free voice) */
  public static final VoiceName MITCHELL = new VoiceName("Mitchell");

  /** Female voice for Japanese (Japan) (Free voice) */
  public static final VoiceName MIZUKI = new VoiceName("Mizuki");

  /** Male voice for Arabic (Qatar) (Free voice) */
  public static final VoiceName MOAZ = new VoiceName("Moaz");

  /** Male voice for Telugu (India) (Free voice) */
  public static final VoiceName MOHAN = new VoiceName("Mohan");

  /** Female voice for English (New Zealand) (Free voice) */
  public static final VoiceName MOLLY = new VoiceName("Molly");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName MONICA = new VoiceName("Monica");

  /** Female voice for Arabic (Morocco) (Free voice) */
  public static final VoiceName MOUNA = new VoiceName("Mouna");

  /** Male voice for Somali (Somalia) (Free voice) */
  public static final VoiceName MUUSE = new VoiceName("Muuse");

  /** Female voice for Bangla (Bangladesh) (Free voice) */
  public static final VoiceName NABANITA = new VoiceName("Nabanita");

  /** Female voice for Danish (Denmark) (Free voice) */
  public static final VoiceName NAJA = new VoiceName("Naja");

  /** Male voice for Vietnamese (Vietnam) (Free voice) */
  public static final VoiceName NAM_MINH = new VoiceName("NamMinh");

  /** Female voice for Japanese (Japan) (Free voice) */
  public static final VoiceName NANAMI = new VoiceName("Nanami");

  /** Female voice for Japanese (Japan) (Paid voice) */
  public static final VoiceName NANAMI_2 = new VoiceName("Nanami_2");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName NANCY = new VoiceName("Nancy");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName NANCY_2 = new VoiceName("Nancy_2");

  /** Male voice for Japanese (Japan) (Free voice) */
  public static final VoiceName NAOKI = new VoiceName("Naoki");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName NATASHA = new VoiceName("Natasha");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName NEERJA = new VoiceName("Neerja");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName NEERJA_2 = new VoiceName("Neerja_2");

  /** Male voice for English (Australia) (Free voice) */
  public static final VoiceName NEIL = new VoiceName("Neil");

  /** Male voice for Greek (Greece) (Free voice) */
  public static final VoiceName NESTORAS = new VoiceName("Nestoras");

  /** Female voice for Welsh (United Kingdom) (Free voice) */
  public static final VoiceName NIA = new VoiceName("Nia");

  /** Female voice for English (Ireland) (Free voice) */
  public static final VoiceName NIAMH = new VoiceName("Niamh");

  /** Female voice for English (Ireland) (Paid voice) */
  public static final VoiceName NIAMH_2 = new VoiceName("Niamh_2");

  /** Male voice for Serbian (Cyrillic, Serbia) (Free voice) */
  public static final VoiceName NICHOLAS = new VoiceName("Nicholas");

  /** Male voice for Serbian (Latin, Serbia) (Free voice) */
  public static final VoiceName NICHOLAS_2 = new VoiceName("Nicholas_2");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName NICOLAU = new VoiceName("Nicolau");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName NICOLE = new VoiceName("Nicole");

  /** Male voice for Spanish (Spain) (Free voice) */
  public static final VoiceName NIL = new VoiceName("Nil");

  /** Female voice for Burmese (Myanmar) (Free voice) */
  public static final VoiceName NILAR = new VoiceName("Nilar");

  /** Male voice for Latvian (Latvia) (Free voice) */
  public static final VoiceName NILS = new VoiceName("Nils");

  /** Male voice for Gujarati (India) (Free voice) */
  public static final VoiceName NIRANJAN = new VoiceName("Niranjan");

  /** Male voice for Thai (Thailand) (Free voice) */
  public static final VoiceName NIWAT = new VoiceName("Niwat");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName NOAH = new VoiceName("Noah");

  /** Female voice for Hungarian (Hungary) (Free voice) */
  public static final VoiceName NOEMI = new VoiceName("Noemi");

  /** Female voice for Finnish (Finland) (Free voice) */
  public static final VoiceName NOORA = new VoiceName("Noora");

  /** Female voice for Arabic (Kuwait) (Free voice) */
  public static final VoiceName NOURA = new VoiceName("Noura");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName NOVA = new VoiceName("Nova");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName NOVA_2 = new VoiceName("Nova_2");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName NURIA = new VoiceName("Nuria");

  /** Male voice for Punjabi (India) (Free voice) */
  public static final VoiceName OJAS = new VoiceName("Ojas");

  /** Female voice for Polish (Poland) (Free voice) */
  public static final VoiceName OLA = new VoiceName("Ola");

  /** Female voice for Polish (Poland) (Paid voice) */
  public static final VoiceName OLA_2 = new VoiceName("Ola_2");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName OLIVER = new VoiceName("Oliver");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName OLIVIA = new VoiceName("Olivia");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName OLLIE = new VoiceName("Ollie");

  /** Male voice for English (United Kingdom) (Paid voice) */
  public static final VoiceName OLLIE_2 = new VoiceName("Ollie_2");

  /** Male voice for Arabic (Libya) (Free voice) */
  public static final VoiceName OMAR = new VoiceName("Omar");

  /** Female voice for Lithuanian (Lithuania) (Free voice) */
  public static final VoiceName ONA = new VoiceName("Ona");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName ONYX = new VoiceName("Onyx");

  /** Female voice for Irish (Ireland) (Free voice) */
  public static final VoiceName ORLA = new VoiceName("Orla");

  /** Male voice for Malay (Malaysia) (Free voice) */
  public static final VoiceName OSMAN = new VoiceName("Osman");

  /** Male voice for Ukrainian (Ukraine) (Free voice) */
  public static final VoiceName OSTAP = new VoiceName("Ostap");

  /** Female voice for Tamil (India) (Free voice) */
  public static final VoiceName PALLAVI = new VoiceName("Pallavi");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName PALMIRA = new VoiceName("Palmira");

  /** Female voice for Spanish (United States) (Free voice) */
  public static final VoiceName PALOMA = new VoiceName("Paloma");

  /** Female voice for Spanish (Venezuela) (Free voice) */
  public static final VoiceName PAOLA = new VoiceName("Paola");

  /** Male voice for Spanish (United States) (Free voice) */
  public static final VoiceName PEDRO = new VoiceName("Pedro");

  /** Male voice for Spanish (United States) (Paid voice) */
  public static final VoiceName PEDRO_2 = new VoiceName("Pedro_2");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName PELAYO = new VoiceName("Pelayo");

  /** Female voice for Spanish (United States) (Free voice) */
  public static final VoiceName PENELOPE = new VoiceName("Penelope");

  /** Female voice for Norwegian (Norway) (Free voice) */
  public static final VoiceName PERNILLE = new VoiceName("Pernille");

  /** Female voice for Slovenian (Slovenia) (Free voice) */
  public static final VoiceName PETRA = new VoiceName("Petra");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName PHOEBE = new VoiceName("Phoebe");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName PHOEBE_2 = new VoiceName("Phoebe_2");

  /** Female voice for Italian (Italy) (Free voice) */
  public static final VoiceName PIERINA = new VoiceName("Pierina");

  /** Male voice for Khmer (Cambodia) (Free voice) */
  public static final VoiceName PISETH = new VoiceName("Piseth");

  /** Female voice for Ukrainian (Ukraine) (Free voice) */
  public static final VoiceName POLINA = new VoiceName("Polina");

  /** Male voice for English (India) (Free voice) */
  public static final VoiceName PRABHAT = new VoiceName("Prabhat");

  /** Male voice for English (India) (Free voice) */
  public static final VoiceName PRABHAT_2 = new VoiceName("Prabhat_2");

  /** Male voice for Bangla (Bangladesh) (Free voice) */
  public static final VoiceName PRADEEP = new VoiceName("Pradeep");

  /** Female voice for Thai (Thailand) (Free voice) */
  public static final VoiceName PREMWADEE = new VoiceName("Premwadee");

  /** Male voice for Assamese (India) (Free voice) */
  public static final VoiceName PRIYOM = new VoiceName("Priyom");

  /** Male voice for Swahili (Kenya) (Free voice) */
  public static final VoiceName RAFIKI = new VoiceName("Rafiki");

  /** Male voice for German (Germany) (Free voice) */
  public static final VoiceName RALF = new VoiceName("Ralf");

  /** Male voice for Arabic (Lebanon) (Free voice) */
  public static final VoiceName RAMI = new VoiceName("Rami");

  /** Female voice for Spanish (Dominican Republic) (Free voice) */
  public static final VoiceName RAMONA = new VoiceName("Ramona");

  /** Female voice for Arabic (Iraq) (Free voice) */
  public static final VoiceName RANA = new VoiceName("Rana");

  /** Female voice for Portuguese (Portugal) (Free voice) */
  public static final VoiceName RAQUEL = new VoiceName("Raquel");

  /** Female voice for English (India) (Free voice) */
  public static final VoiceName RAVEENA = new VoiceName("Raveena");

  /** Female voice for Arabic (Tunisia) (Free voice) */
  public static final VoiceName REEM = new VoiceName("Reem");

  /** Male voice for Hindi (India) (Free voice) */
  public static final VoiceName REHAAN = new VoiceName("Rehaan");

  /** Male voice for English (India) (Free voice) */
  public static final VoiceName REHAAN_2 = new VoiceName("Rehaan_2");

  /** Female voice for Swahili (Tanzania) (Free voice) */
  public static final VoiceName REHEMA = new VoiceName("Rehema");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName REMI = new VoiceName("Remi");

  /** Male voice for French (France) (Paid voice) */
  public static final VoiceName REMI_2 = new VoiceName("Remi_2");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName REMY = new VoiceName("Remy");

  /** Male voice for French (France) (Paid voice) */
  public static final VoiceName REMY_2 = new VoiceName("Remy_2");

  /** Female voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName RENATA = new VoiceName("Renata");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName RICARDO = new VoiceName("Ricardo");

  /** Male voice for Italian (Italy) (Free voice) */
  public static final VoiceName RINALDO = new VoiceName("Rinaldo");

  /** Male voice for Spanish (Panama) (Free voice) */
  public static final VoiceName ROBERTO = new VoiceName("Roberto");

  /** Male voice for Spanish (El Salvador) (Free voice) */
  public static final VoiceName RODRIGO = new VoiceName("Rodrigo");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName ROGER = new VoiceName("Roger");

  /** Male voice for Galician (Free voice) */
  public static final VoiceName ROI = new VoiceName("Roi");

  /** Male voice for Slovenian (Slovenia) (Free voice) */
  public static final VoiceName ROK = new VoiceName("Rok");

  /** Female voice for English (Philippines) (Free voice) */
  public static final VoiceName ROSA = new VoiceName("Rosa");

  /** Male voice for Dutch (Netherlands) (Free voice) */
  public static final VoiceName RUBEN = new VoiceName("Ruben");

  /** Male voice for English (Australia) (Free voice) */
  public static final VoiceName RUSSELL = new VoiceName("Russell");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName RUTH = new VoiceName("Ruth");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName RUTH_2 = new VoiceName("Ruth_2");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName RYAN = new VoiceName("Ryan");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName RYAN_2 = new VoiceName("Ryan_2");

  /** Female voice for Galician (Free voice) */
  public static final VoiceName SABELA = new VoiceName("Sabela");

  /** Female voice for German (Switzerland) (Free voice) */
  public static final VoiceName SABRINA = new VoiceName("Sabrina");

  /** Female voice for German (Switzerland) (Paid voice) */
  public static final VoiceName SABRINA_2 = new VoiceName("Sabrina_2");

  /** Male voice for Nepali (Nepal) (Free voice) */
  public static final VoiceName SAGAR = new VoiceName("Sagar");

  /** Male voice for Arabic (Yemen) (Free voice) */
  public static final VoiceName SALEH = new VoiceName("Saleh");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName SALLI = new VoiceName("Salli");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName SALLI_2 = new VoiceName("Salli_2");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName SALLI_3 = new VoiceName("Salli_3");

  /** Female voice for Arabic (Egypt) (Free voice) */
  public static final VoiceName SALMA = new VoiceName("Salma");

  /** Male voice for Urdu (India) (Free voice) */
  public static final VoiceName SALMAN = new VoiceName("Salman");

  /** Female voice for Spanish (Colombia) (Free voice) */
  public static final VoiceName SALOME = new VoiceName("Salome");

  /** Male voice for English (Hong Kong SAR) (Free voice) */
  public static final VoiceName SAM = new VoiceName("Sam");

  /** Male voice for Sinhala (Sri Lanka) (Free voice) */
  public static final VoiceName SAMEERA = new VoiceName("Sameera");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName SAMUEL = new VoiceName("Samuel");

  /** Female voice for Arabic (Jordan) (Free voice) */
  public static final VoiceName SANA = new VoiceName("Sana");

  /** Female voice for Kannada (India) (Free voice) */
  public static final VoiceName SAPNA = new VoiceName("Sapna");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName SARA = new VoiceName("Sara");

  /** Female voice for Tamil (Sri Lanka) (Free voice) */
  public static final VoiceName SARANYA = new VoiceName("Saranya");

  /** Male voice for Uzbek (Latin, Uzbekistan) (Free voice) */
  public static final VoiceName SARDOR = new VoiceName("Sardor");

  /** Male voice for Spanish (Spain) (Free voice) */
  public static final VoiceName SAUL = new VoiceName("Saul");

  /** Male voice for Spanish (Venezuela) (Free voice) */
  public static final VoiceName SEBASTIAN = new VoiceName("Sebastian");

  /** Female voice for Finnish (Finland) (Free voice) */
  public static final VoiceName SELMA = new VoiceName("Selma");

  /** Female voice for Korean (Korea) (Free voice) */
  public static final VoiceName SEO_HYEON = new VoiceName("SeoHyeon");

  /** Female voice for Korean (Korea) (Free voice) */
  public static final VoiceName SEOYEON = new VoiceName("Seoyeon");

  /** Female voice for Korean (Korea) (Free voice) */
  public static final VoiceName SEOYEON_2 = new VoiceName("Seoyeon_2");

  /** Female voice for Korean (Korea) (Paid voice) */
  public static final VoiceName SEOYEON_3 = new VoiceName("Seoyeon_3");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName SERAPHINA = new VoiceName("Seraphina");

  /** Female voice for German (Germany) (Paid voice) */
  public static final VoiceName SERAPHINA_2 = new VoiceName("Seraphina_2");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName SERENA = new VoiceName("Serena");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName SERENA_2 = new VoiceName("Serena_2");

  /** Male voice for Spanish (Castilian) (Free voice) */
  public static final VoiceName SERGIO = new VoiceName("Sergio");

  /** Male voice for Spanish (Castilian) (Paid voice) */
  public static final VoiceName SERGIO_2 = new VoiceName("Sergio_2");

  /** Male voice for Arabic (Egypt) (Free voice) */
  public static final VoiceName SHAKIR = new VoiceName("Shakir");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName SHIMMER = new VoiceName("Shimmer");

  /** Female voice for Japanese (Japan) (Free voice) */
  public static final VoiceName SHIORI = new VoiceName("Shiori");

  /** Female voice for Telugu (India) (Free voice) */
  public static final VoiceName SHRUTI = new VoiceName("Shruti");

  /** Female voice for Inuktitut (Syllabics, Canada) (Free voice) */
  public static final VoiceName SIQINIQ = new VoiceName("Siqiniq");

  /** Female voice for Inuktitut (Latin, Canada) (Free voice) */
  public static final VoiceName SIQINIQ_2 = new VoiceName("Siqiniq_2");

  /** Female voice for Javanese (Latin, Indonesia) (Free voice) */
  public static final VoiceName SITI = new VoiceName("Siti");

  /** Female voice for Malayalam (India) (Free voice) */
  public static final VoiceName SOBHANA = new VoiceName("Sobhana");

  /** Female voice for Danish (Denmark) (Free voice) */
  public static final VoiceName SOFFIE = new VoiceName("Soffie");

  /** Female voice for Spanish (Bolivia) (Free voice) */
  public static final VoiceName SOFIA = new VoiceName("Sofia");

  /** Female voice for Swedish (Sweden) (Free voice) */
  public static final VoiceName SOFIE = new VoiceName("Sofie");

  /** Female voice for English (United Kingdom) (Free voice) */
  public static final VoiceName SONIA = new VoiceName("Sonia");

  /** Female voice for Korean (Korea) (Free voice) */
  public static final VoiceName SOON_BOK = new VoiceName("SoonBok");

  /** Female voice for Serbian (Cyrillic, Serbia) (Free voice) */
  public static final VoiceName SOPHIE = new VoiceName("Sophie");

  /** Female voice for Serbian (Latin, Serbia) (Free voice) */
  public static final VoiceName SOPHIE_2 = new VoiceName("Sophie_2");

  /** Male voice for Croatian (Croatia) (Free voice) */
  public static final VoiceName SRECKO = new VoiceName("Srecko");

  /** Female voice for Khmer (Cambodia) (Free voice) */
  public static final VoiceName SREYMOM = new VoiceName("Sreymom");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName STEFFAN = new VoiceName("Steffan");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName STEFFAN_2 = new VoiceName("Steffan_2");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName STEFFAN_3 = new VoiceName("Steffan_3");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName STEPHEN = new VoiceName("Stephen");

  /** Male voice for English (United States) (Paid voice) */
  public static final VoiceName STEPHEN_2 = new VoiceName("Stephen_2");

  /** Female voice for Odia (India) (Free voice) */
  public static final VoiceName SUBHASINI = new VoiceName("Subhasini");

  /** Male voice for Odia (India) (Free voice) */
  public static final VoiceName SUKANT = new VoiceName("Sukant");

  /** Female voice for Korean (Korea) (Free voice) */
  public static final VoiceName SUN_HI = new VoiceName("SunHi");

  /** Female voice for Korean (Korea) (Paid voice) */
  public static final VoiceName SUN_HI_2 = new VoiceName("SunHi_2");

  /** Male voice for Tamil (Malaysia) (Free voice) */
  public static final VoiceName SURYA = new VoiceName("Surya");

  /** Female voice for Finnish (Finland) (Free voice) */
  public static final VoiceName SUVI = new VoiceName("Suvi");

  /** Female voice for Russian (Russia) (Free voice) */
  public static final VoiceName SVETLANA = new VoiceName("Svetlana");

  /** Female voice for Hindi (India) (Free voice) */
  public static final VoiceName SWARA = new VoiceName("Swara");

  /** Female voice for French (Canada) (Free voice) */
  public static final VoiceName SYLVIE = new VoiceName("Sylvie");

  /** Female voice for French (Canada) (Paid voice) */
  public static final VoiceName SYLVIE_2 = new VoiceName("Sylvie_2");

  /** Male voice for Arabic (Jordan) (Free voice) */
  public static final VoiceName TAIM = new VoiceName("Taim");

  /** Male voice for Japanese (Japan) (Free voice) */
  public static final VoiceName TAKUMI = new VoiceName("Takumi");

  /** Male voice for Japanese (Japan) (Free voice) */
  public static final VoiceName TAKUMI_2 = new VoiceName("Takumi_2");

  /** Male voice for Hungarian (Hungary) (Free voice) */
  public static final VoiceName TAMAS = new VoiceName("Tamas");

  /** Female voice for Spanish (Paraguay) (Free voice) */
  public static final VoiceName TANIA = new VoiceName("Tania");

  /** Female voice for Bengali (India) (Free voice) */
  public static final VoiceName TANISHAA = new VoiceName("Tanishaa");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName TANJA = new VoiceName("Tanja");

  /** Male voice for Inuktitut (Syllabics, Canada) (Free voice) */
  public static final VoiceName TAQQIQ = new VoiceName("Taqqiq");

  /** Male voice for Inuktitut (Latin, Canada) (Free voice) */
  public static final VoiceName TAQQIQ_2 = new VoiceName("Taqqiq_2");

  /** Female voice for Russian (Russia) (Free voice) */
  public static final VoiceName TATYANA = new VoiceName("Tatyana");

  /** Male voice for Spanish (Spain) (Free voice) */
  public static final VoiceName TEO = new VoiceName("Teo");

  /** Female voice for Spanish (Equatorial Guinea) (Free voice) */
  public static final VoiceName TERESA = new VoiceName("Teresa");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName THALITA = new VoiceName("Thalita");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName THALITA_2 = new VoiceName("Thalita_2");

  /** Female voice for Portuguese (Brazil) (Paid voice) */
  public static final VoiceName THALITA_3 = new VoiceName("Thalita_3");

  /** Female voice for Zulu (South Africa) (Free voice) */
  public static final VoiceName THANDO = new VoiceName("Thando");

  /** Male voice for Zulu (South Africa) (Free voice) */
  public static final VoiceName THEMBA = new VoiceName("Themba");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName THIAGO = new VoiceName("Thiago");

  /** Male voice for French (Canada) (Free voice) */
  public static final VoiceName THIERRY = new VoiceName("Thierry");

  /** Male voice for French (Canada) (Paid voice) */
  public static final VoiceName THIERRY_2 = new VoiceName("Thierry_2");

  /** Male voice for Burmese (Myanmar) (Free voice) */
  public static final VoiceName THIHA = new VoiceName("Thiha");

  /** Female voice for Sinhala (Sri Lanka) (Free voice) */
  public static final VoiceName THILINI = new VoiceName("Thilini");

  /** Male voice for English (United Kingdom) (Free voice) */
  public static final VoiceName THOMAS = new VoiceName("Thomas");

  /** Female voice for English (United States) (Free voice) */
  public static final VoiceName TIANA = new VoiceName("Tiana");

  /** Female voice for English (United States) (Paid voice) */
  public static final VoiceName TIFFANY = new VoiceName("Tiffany");

  /** Male voice for English (Australia) (Free voice) */
  public static final VoiceName TIM = new VoiceName("Tim");

  /** Female voice for English (Australia) (Free voice) */
  public static final VoiceName TINA = new VoiceName("Tina");

  /** Male voice for Spanish (Argentina) (Free voice) */
  public static final VoiceName TOMAS = new VoiceName("Tomas");

  /** Female voice for Japanese (Japan) (Free voice) */
  public static final VoiceName TOMOKO = new VoiceName("Tomoko");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName TONY = new VoiceName("Tony");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName TRIANA = new VoiceName("Triana");

  /** Male voice for Spanish (Mexico) (Paid voice) */
  public static final VoiceName TRISTAN = new VoiceName("Tristan");

  /** Male voice for Spanish (Spain) (Free voice) */
  public static final VoiceName TRISTAN_ES = new VoiceName("Tristan_ES");

  /** Male voice for Spanish (Spain) (Paid voice) */
  public static final VoiceName TRISTAN_ES_2 = new VoiceName("Tristan_ES_2");

  /** Female voice for Sundanese (Indonesia) (Free voice) */
  public static final VoiceName TUTI = new VoiceName("Tuti");

  /** Male voice for English (United States) (Free voice) */
  public static final VoiceName TYLER = new VoiceName("Tyler");

  /** Female voice for Somali (Somalia) (Free voice) */
  public static final VoiceName UBAX = new VoiceName("Ubax");

  /** Female voice for Urdu (Pakistan) (Free voice) */
  public static final VoiceName UZMA = new VoiceName("Uzma");

  /** Female voice for Punjabi (India) (Free voice) */
  public static final VoiceName VAANI = new VoiceName("Vaani");

  /** Female voice for Spanish (Uruguay) (Free voice) */
  public static final VoiceName VALENTINA = new VoiceName("Valentina");

  /** Male voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName VALERIO = new VoiceName("Valerio");

  /** Male voice for Tamil (India) (Free voice) */
  public static final VoiceName VALLUVAR = new VoiceName("Valluvar");

  /** Female voice for Tamil (Singapore) (Free voice) */
  public static final VoiceName VENBA = new VoiceName("Venba");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName VERA = new VoiceName("Vera");

  /** Female voice for Bosnian (Bosnia and Herzegovina) (Free voice) */
  public static final VoiceName VESNA = new VoiceName("Vesna");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName VICKI = new VoiceName("Vicki");

  /** Female voice for German (Germany) (Free voice) */
  public static final VoiceName VICKI_2 = new VoiceName("Vicki_2");

  /** Female voice for German (Germany) (Paid voice) */
  public static final VoiceName VICKI_3 = new VoiceName("Vicki_3");

  /** Male voice for Spanish (Puerto Rico) (Free voice) */
  public static final VoiceName VICTOR = new VoiceName("Victor");

  /** Female voice for Slovak (Slovakia) (Free voice) */
  public static final VoiceName VIKTORIA = new VoiceName("Viktoria");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName VITORIA = new VoiceName("Vitoria");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName VITORIA_2 = new VoiceName("Vitoria_2");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName VIVIENNE = new VoiceName("Vivienne");

  /** Female voice for French (France) (Paid voice) */
  public static final VoiceName VIVIENNE_2 = new VoiceName("Vivienne_2");

  /** Female voice for Czech (Czechia) (Free voice) */
  public static final VoiceName VLASTA = new VoiceName("Vlasta");

  /** Male voice for Chinese (Cantonese, Traditional) (Free voice) */
  public static final VoiceName WAN_LUNG = new VoiceName("WanLung");

  /** Male voice for English (Singapore) (Free voice) */
  public static final VoiceName WAYNE = new VoiceName("Wayne");

  /** Male voice for Afrikaans (South Africa) (Free voice) */
  public static final VoiceName WILLEM = new VoiceName("Willem");

  /** Male voice for English (Australia) (Free voice) */
  public static final VoiceName WILLIAM = new VoiceName("William");

  /** Male voice for English (Australia) (Free voice) */
  public static final VoiceName WILLIAM_2 = new VoiceName("William_2");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOCHEN = new VoiceName("Xiaochen");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOCHEN_2 = new VoiceName("Xiaochen_2");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOCHEN_3 = new VoiceName("Xiaochen_3");

  /** Female voice for Chinese (Mandarin, Simplified) (Paid voice) */
  public static final VoiceName XIAOCHEN_4 = new VoiceName("Xiaochen_4");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOHAN = new VoiceName("Xiaohan");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOHAN_2 = new VoiceName("Xiaohan_2");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOMENG = new VoiceName("Xiaomeng");

  /** Female voice for Chinese (Cantonese, Simplified) (Free voice) */
  public static final VoiceName XIAO_MIN = new VoiceName("XiaoMin");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOMO = new VoiceName("Xiaomo");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOQIU = new VoiceName("Xiaoqiu");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOROU = new VoiceName("Xiaorou");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAORUI = new VoiceName("Xiaorui");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOSHUANG = new VoiceName("Xiaoshuang");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOSHUANG_2 = new VoiceName("Xiaoshuang_2");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOSHUANG_3 = new VoiceName("Xiaoshuang_3");

  /** Female voice for Chinese (Wu, Simplified) (Free voice) */
  public static final VoiceName XIAOTONG = new VoiceName("Xiaotong");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOXIAO = new VoiceName("Xiaoxiao");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOXIAO_2 = new VoiceName("Xiaoxiao_2");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOXIAO_3 = new VoiceName("Xiaoxiao_3");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOXIAO_4 = new VoiceName("Xiaoxiao_4");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOXIAO_5 = new VoiceName("Xiaoxiao_5");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOYAN = new VoiceName("Xiaoyan");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOYI = new VoiceName("Xiaoyi");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOYI_2 = new VoiceName("Xiaoyi_2");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOYOU = new VoiceName("Xiaoyou");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOYOU_2 = new VoiceName("Xiaoyou_2");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOYOU_3 = new VoiceName("Xiaoyou_3");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOYU = new VoiceName("Xiaoyu");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOYU_2 = new VoiceName("Xiaoyu_2");

  /** Female voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName XIAOZHEN = new VoiceName("Xiaozhen");

  /** Female voice for Spanish (Mexico) (Paid voice) */
  public static final VoiceName XIMENA = new VoiceName("Ximena");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName XIMENA_ES = new VoiceName("Ximena_ES");

  /** Female voice for Spanish (Spain) (Free voice) */
  public static final VoiceName XIMENA_ES_2 = new VoiceName("Ximena_ES_2");

  /** Female voice for Spanish (Spain) (Paid voice) */
  public static final VoiceName XIMENA_ES_3 = new VoiceName("Ximena_ES_3");

  /** Male voice for Spanish (Mexico) (Free voice) */
  public static final VoiceName YAGO = new VoiceName("Yago");

  /** Female voice for English (Hong Kong SAR) (Free voice) */
  public static final VoiceName YAN = new VoiceName("Yan");

  /** Female voice for Portuguese (Brazil) (Free voice) */
  public static final VoiceName YARA = new VoiceName("Yara");

  /** Female voice for Assamese (India) (Free voice) */
  public static final VoiceName YASHICA = new VoiceName("Yashica");

  /** Female voice for Malay (Malaysia) (Free voice) */
  public static final VoiceName YASMIN = new VoiceName("Yasmin");

  /** Female voice for Mongolian (Mongolia) (Free voice) */
  public static final VoiceName YESUI = new VoiceName("Yesui");

  /** Female voice for Spanish (Nicaragua) (Free voice) */
  public static final VoiceName YOLANDA = new VoiceName("Yolanda");

  /** Female voice for Korean (Korea) (Free voice) */
  public static final VoiceName YU_JIN = new VoiceName("YuJin");

  /** Male voice for Chinese (Zhongyuan Mandarin Henan, Simplified) (Free voice) */
  public static final VoiceName YUNDENG = new VoiceName("Yundeng");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNFAN = new VoiceName("Yunfan");

  /** Male voice for Chinese (Mandarin, Simplified) (Paid voice) */
  public static final VoiceName YUNFAN_2 = new VoiceName("Yunfan_2");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNFENG = new VoiceName("Yunfeng");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNHAN = new VoiceName("Yunhan");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNHAO = new VoiceName("Yunhao");

  /** Male voice for Chinese (Taiwanese Mandarin, Traditional) (Free voice) */
  public static final VoiceName YUN_JHE = new VoiceName("YunJhe");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNJIAN = new VoiceName("Yunjian");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNJIE = new VoiceName("Yunjie");

  /** Male voice for Chinese (Cantonese, Simplified) (Free voice) */
  public static final VoiceName YUN_SONG = new VoiceName("YunSong");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNXI = new VoiceName("Yunxi");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNXI_2 = new VoiceName("Yunxi_2");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNXIA = new VoiceName("Yunxia");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNXIA_2 = new VoiceName("Yunxia_2");

  /** Male voice for Chinese (Jilu Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNXIANG = new VoiceName("Yunxiang");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNXIAO = new VoiceName("Yunxiao");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNXIAO_2 = new VoiceName("Yunxiao_2");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNYANG = new VoiceName("Yunyang");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNYE = new VoiceName("Yunye");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNYE_2 = new VoiceName("Yunye_2");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNYI = new VoiceName("Yunyi");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNYI_2 = new VoiceName("Yunyi_2");

  /** Male voice for Chinese (Mandarin, Simplified) (Free voice) */
  public static final VoiceName YUNZE = new VoiceName("Yunze");

  /** Male voice for Chinese (Wu, Simplified) (Free voice) */
  public static final VoiceName YUNZHE = new VoiceName("Yunzhe");

  /** Male voice for French (France) (Free voice) */
  public static final VoiceName YVES = new VoiceName("Yves");

  /** Female voice for French (France) (Free voice) */
  public static final VoiceName YVETTE = new VoiceName("Yvette");

  /** Female voice for Arabic (Saudi Arabia) (Free voice) */
  public static final VoiceName ZARIYAH = new VoiceName("Zariyah");

  /** Male voice for Arabic (Saudi Arabia) (Free voice) */
  public static final VoiceName ZAYD = new VoiceName("Zayd");

  /** Female voice for Arabic (Saudi Arabia) (Free voice) */
  public static final VoiceName ZEINA = new VoiceName("Zeina");

  /** Female voice for Chinese (Mandarin) (Free voice) */
  public static final VoiceName ZHIYU = new VoiceName("Zhiyu");

  /** Female voice for Chinese (Mandarin) (Free voice) */
  public static final VoiceName ZHIYU_2 = new VoiceName("Zhiyu_2");

  /** Female voice for Polish (Poland) (Free voice) */
  public static final VoiceName ZOFIA = new VoiceName("Zofia");

  /** Female voice for Swahili (Kenya) (Free voice) */
  public static final VoiceName ZURI = new VoiceName("Zuri");

  private static final EnumSupportDynamic<String, VoiceName> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          VoiceName.class,
          VoiceName::new,
          Arrays.asList(
              AARAV,
              AARAV_2,
              AAROHI,
              AARTI,
              AARTI_2,
              AARTI_3,
              AASHI,
              ABBI,
              ABDULLAH,
              ABEO,
              ABRIL,
              ACHARA,
              ADA,
              ADA_2,
              ADAM,
              ADAM_2,
              ADITI,
              ADRI,
              ADRIANO,
              AGNIESZKA,
              AHMET,
              AIGUL,
              AINHOA,
              ALAIN,
              ALBA,
              ALED,
              ALEKSANDAR,
              ALESSIO,
              ALESSIO_2,
              ALEX,
              ALFIE,
              ALI,
              ALINA,
              ALLOY,
              ALLOY_2,
              ALONSO,
              ALVARO,
              AMAL,
              AMALA,
              AMANDA,
              AMANY,
              AMBER,
              AMBRE,
              AMEHA,
              AMINA,
              AMY,
              AMY_2,
              AMY_3,
              ANA,
              ANAHIT,
              ANANYA,
              ANANYA_2,
              ANBU,
              ANDER,
              ANDRE,
              ANDRE_2,
              ANDREA,
              ANDRES,
              ANDREW,
              ANDREW_2,
              ANDREW_3,
              ANDREW_4,
              ANGELO,
              ANILA,
              ANNETTE,
              ANTOINE,
              ANTONIN,
              ANTONIO,
              ANU,
              AOI,
              ARABELLA,
              ARDI,
              ARIA,
              ARIA_2,
              ARIANE,
              ARJUN,
              ARJUN_2,
              ARJUN_3,
              ARLET,
              ARNAU,
              ARNAUD,
              ARTHUR,
              ARYA,
              ARYA_2,
              ASAD,
              ASHLEY,
              ASILIA,
              ASTRID,
              ATHINA,
              AVA,
              AVA_2,
              AVA_3,
              AVRI,
              AYANDA,
              AYANDA_2,
              AYSHA,
              BABEK,
              BANU,
              BASHKAR,
              BASSEL,
              BATAA,
              BEATRICE,
              BEATRIZ,
              BELKYS,
              BELLA,
              BENIGNO,
              BERND,
              BIANCA,
              BIANCA_2,
              BIANCA_3,
              BLESSICA,
              BONG_JIN,
              BORISLAV,
              BRANDON,
              BRANDON_2,
              BREE,
              BRENDA,
              BRIAN,
              BRIAN_2,
              BRIAN_3,
              BRIGITTE,
              BRYAN,
              BRYAN_2,
              BRYAN_3,
              BURCU,
              CALIMERO,
              CAMILA,
              CAMILLA,
              CAMILLA_2,
              CAMILLA_3,
              CANDELA,
              CARLA,
              CARLOS,
              CARLOTA,
              CARLY,
              CARMEN,
              CATALDO,
              CATALINA,
              CECILIO,
              CELESTE,
              CELINE,
              CELINE_2,
              CHANTAL,
              CHANTHAVONG,
              CHARLINE,
              CHILEMBA,
              CHRISTEL,
              CHRISTOPH,
              CHRISTOPHER,
              CHRISTOPHER_2,
              CLARA,
              CLAUDE,
              COLETTE,
              COLM,
              CONCHITA,
              CONNOR,
              CONRAD,
              CORA,
              CORA_2,
              CORALIE,
              CRISTIANO,
              DAICHI,
              DALIA,
              DALIA_2,
              DANIEL,
              DANIEL_2,
              DANIELLE,
              DANIELLE_2,
              DARIO,
              DARIYA,
              DARREN,
              DAUDI,
              DAULET,
              DAVIS,
              DAVIS_2,
              DAVIS_3,
              DENA,
              DENISE,
              DEREK,
              DHWANI,
              DIEGO,
              DILARA,
              DIMAS,
              DMITRY,
              DONATO,
              DORA,
              DUARTE,
              DUNCAN,
              DUSTIN,
              ECHO,
              EKA,
              ELENA,
              ELIAS,
              ELIMU,
              ELIN,
              ELIZABETH,
              ELKE,
              ELLIOT,
              ELOISE,
              ELSA,
              ELSIE,
              ELVIRA,
              ELZA,
              EMEL,
              EMIL,
              EMILIO,
              EMILY,
              EMMA,
              EMMA_2,
              EMMA_3,
              EMMA_4,
              ENRIC,
              ENRIQUE,
              ERIC,
              ESTRELLA,
              ETHAN,
              EVELYN,
              EVERITA,
              EWA,
              EWA_2,
              EZINNE,
              FABIO,
              FABIOLA,
              FABLE,
              FABRICE,
              FAHED,
              FARID,
              FATIMA,
              FEDERICO,
              FENNA,
              FERNANDA,
              FIAMMA,
              FILIZ,
              FINN,
              FLORIAN,
              FLORIAN_2,
              FLORIN,
              FRANCISCA,
              FREYA,
              GABRIELLE,
              GABRIELLE_2,
              GABRIJELA,
              GADIS,
              GAGAN,
              GEMMA,
              GEMMA_2,
              GERAINT,
              GERARD,
              GERARDO,
              GIANNI,
              GIORGI,
              GIORGIO,
              GIOVANNA,
              GISELA,
              GIUSEPPE,
              GIUSEPPE_2,
              GONZALO,
              GOOK_MIN,
              GORAN,
              GRACE,
              GREGORY,
              GUDRUN,
              GUL,
              GUL_NAWAZ,
              GUNNAR,
              GUY,
              GWYNETH,
              HALA,
              HAMDAN,
              HAMED,
              HANNAH,
              HANNAH_2,
              HANS,
              HARRI,
              HAYK,
              HEDI,
              HEMKALA,
              HENRI,
              HILA,
              HILLEVI,
              HIU_GAAI,
              HIUJIN,
              HIU_MAAN,
              HOAI_MY,
              HOLLIE,
              HSIAO_CHEN,
              HSIAO_YU,
              HUMBERTO,
              HYUNSU,
              HYUNSU_2,
              HYUNSU_3,
              IDA,
              ILIR,
              IMAN,
              IMANI,
              IMELDA,
              INES,
              INES_2,
              INGRID,
              IN_JOON,
              IRENE,
              IRMA,
              ISABELLA,
              ISABELLA_2,
              ISABELLA_3,
              ISABELLE,
              ISABELLE_2,
              ISELIN,
              ISIDORA,
              ISMAEL,
              IVY,
              IVY_2,
              JACEK,
              JACOB,
              JACQUELINE,
              JAJANG,
              JAMAL,
              JAMES,
              JAN,
              JANE,
              JANE_2,
              JANN,
              JASMINE,
              JASMINE_2,
              JASON,
              JAVIER,
              JEAN,
              JENNY,
              JENNY_2,
              JENNY_3,
              JEPPE,
              JEROME,
              JIHYE,
              JI_MIN,
              JIMMIE,
              JITKA,
              JOANA,
              JOANNA,
              JOANNA_2,
              JOANNA_3,
              JOANNE,
              JOEY,
              JOEY_2,
              JONAS,
              JORGE,
              JORGE_2,
              JOSEPH,
              JOSEPHINE,
              JUAN,
              JULIO,
              JUSTIN,
              JUSTIN_2,
              KAI,
              KAJAL,
              KAJAL_2,
              KALINA,
              KANI,
              KARINA,
              KARL,
              KARLA,
              KASPER,
              KATJA,
              KAVYA,
              KAVYA_2,
              KAZUHA,
              KEITA,
              KEN,
              KENDRA,
              KENDRA_2,
              KEOMANY,
              KERT,
              KEVIN,
              KILLIAN,
              KIM,
              KIMBERLY,
              KIMBERLY_2,
              KLARISSA,
              KLAUS,
              KUMAR,
              KUNAL,
              KUNAL_2,
              LAIA,
              LAILA,
              LAITH,
              LARISSA,
              LATIFA,
              LAURA,
              LAURA_2,
              LAYLA,
              LEA,
              LEA_2,
              LEA_3,
              LEAH,
              LEILA,
              LENI,
              LENNART,
              LEONAS,
              LETICIA,
              LEWIS,
              LIA,
              LIAM,
              LIAN,
              LIAN_2,
              LIBBY,
              LIBERTO,
              LISA,
              LISA_2,
              LISANDRO,
              LIV,
              LIVIA,
              LIVIA_2,
              LOLA,
              LORENA,
              LORENZIO,
              LORENZO,
              LOTTE,
              LOUISA,
              LUCIA,
              LUCIA_2,
              LUCIA_3,
              LUCIANO,
              LUCIEN,
              LUIS,
              LUKAS,
              LUKE,
              LUNA,
              LUNA_2,
              LUPE,
              LUPE_2,
              LUPE_3,
              MAARTEN,
              MACERIO,
              MACERIO_2,
              MADHUR,
              MADINA,
              MADS,
              MAISIE,
              MAJA,
              MANOHAR,
              MANUEL,
              MANUELA,
              MARCELLO,
              MARCELO,
              MAREK,
              MARGARITA,
              MARIA,
              MARIJA,
              MARINA,
              MARIO,
              MARLENE,
              MARTA,
              MARYAM,
              MASARU,
              MATEO,
              MATHIEU,
              MATTHEW,
              MATTHEW_2,
              MATTHEW_3,
              MATTIAS,
              MAURICE,
              MAXIM,
              MAYA,
              MAYU,
              MEKDES,
              MIA,
              MIA_2,
              MIA_3,
              MICHELLE,
              MIDHUN,
              MIGUEL,
              MITCHELL,
              MIZUKI,
              MOAZ,
              MOHAN,
              MOLLY,
              MONICA,
              MOUNA,
              MUUSE,
              NABANITA,
              NAJA,
              NAM_MINH,
              NANAMI,
              NANAMI_2,
              NANCY,
              NANCY_2,
              NAOKI,
              NATASHA,
              NEERJA,
              NEERJA_2,
              NEIL,
              NESTORAS,
              NIA,
              NIAMH,
              NIAMH_2,
              NICHOLAS,
              NICHOLAS_2,
              NICOLAU,
              NICOLE,
              NIL,
              NILAR,
              NILS,
              NIRANJAN,
              NIWAT,
              NOAH,
              NOEMI,
              NOORA,
              NOURA,
              NOVA,
              NOVA_2,
              NURIA,
              OJAS,
              OLA,
              OLA_2,
              OLIVER,
              OLIVIA,
              OLLIE,
              OLLIE_2,
              OMAR,
              ONA,
              ONYX,
              ORLA,
              OSMAN,
              OSTAP,
              PALLAVI,
              PALMIRA,
              PALOMA,
              PAOLA,
              PEDRO,
              PEDRO_2,
              PELAYO,
              PENELOPE,
              PERNILLE,
              PETRA,
              PHOEBE,
              PHOEBE_2,
              PIERINA,
              PISETH,
              POLINA,
              PRABHAT,
              PRABHAT_2,
              PRADEEP,
              PREMWADEE,
              PRIYOM,
              RAFIKI,
              RALF,
              RAMI,
              RAMONA,
              RANA,
              RAQUEL,
              RAVEENA,
              REEM,
              REHAAN,
              REHAAN_2,
              REHEMA,
              REMI,
              REMI_2,
              REMY,
              REMY_2,
              RENATA,
              RICARDO,
              RINALDO,
              ROBERTO,
              RODRIGO,
              ROGER,
              ROI,
              ROK,
              ROSA,
              RUBEN,
              RUSSELL,
              RUTH,
              RUTH_2,
              RYAN,
              RYAN_2,
              SABELA,
              SABRINA,
              SABRINA_2,
              SAGAR,
              SALEH,
              SALLI,
              SALLI_2,
              SALLI_3,
              SALMA,
              SALMAN,
              SALOME,
              SAM,
              SAMEERA,
              SAMUEL,
              SANA,
              SAPNA,
              SARA,
              SARANYA,
              SARDOR,
              SAUL,
              SEBASTIAN,
              SELMA,
              SEO_HYEON,
              SEOYEON,
              SEOYEON_2,
              SEOYEON_3,
              SERAPHINA,
              SERAPHINA_2,
              SERENA,
              SERENA_2,
              SERGIO,
              SERGIO_2,
              SHAKIR,
              SHIMMER,
              SHIORI,
              SHRUTI,
              SIQINIQ,
              SIQINIQ_2,
              SITI,
              SOBHANA,
              SOFFIE,
              SOFIA,
              SOFIE,
              SONIA,
              SOON_BOK,
              SOPHIE,
              SOPHIE_2,
              SRECKO,
              SREYMOM,
              STEFFAN,
              STEFFAN_2,
              STEFFAN_3,
              STEPHEN,
              STEPHEN_2,
              SUBHASINI,
              SUKANT,
              SUN_HI,
              SUN_HI_2,
              SURYA,
              SUVI,
              SVETLANA,
              SWARA,
              SYLVIE,
              SYLVIE_2,
              TAIM,
              TAKUMI,
              TAKUMI_2,
              TAMAS,
              TANIA,
              TANISHAA,
              TANJA,
              TAQQIQ,
              TAQQIQ_2,
              TATYANA,
              TEO,
              TERESA,
              THALITA,
              THALITA_2,
              THALITA_3,
              THANDO,
              THEMBA,
              THIAGO,
              THIERRY,
              THIERRY_2,
              THIHA,
              THILINI,
              THOMAS,
              TIANA,
              TIFFANY,
              TIM,
              TINA,
              TOMAS,
              TOMOKO,
              TONY,
              TRIANA,
              TRISTAN,
              TRISTAN_ES,
              TRISTAN_ES_2,
              TUTI,
              TYLER,
              UBAX,
              UZMA,
              VAANI,
              VALENTINA,
              VALERIO,
              VALLUVAR,
              VENBA,
              VERA,
              VESNA,
              VICKI,
              VICKI_2,
              VICKI_3,
              VICTOR,
              VIKTORIA,
              VITORIA,
              VITORIA_2,
              VIVIENNE,
              VIVIENNE_2,
              VLASTA,
              WAN_LUNG,
              WAYNE,
              WILLEM,
              WILLIAM,
              WILLIAM_2,
              XIAOCHEN,
              XIAOCHEN_2,
              XIAOCHEN_3,
              XIAOCHEN_4,
              XIAOHAN,
              XIAOHAN_2,
              XIAOMENG,
              XIAO_MIN,
              XIAOMO,
              XIAOQIU,
              XIAOROU,
              XIAORUI,
              XIAOSHUANG,
              XIAOSHUANG_2,
              XIAOSHUANG_3,
              XIAOTONG,
              XIAOXIAO,
              XIAOXIAO_2,
              XIAOXIAO_3,
              XIAOXIAO_4,
              XIAOXIAO_5,
              XIAOYAN,
              XIAOYI,
              XIAOYI_2,
              XIAOYOU,
              XIAOYOU_2,
              XIAOYOU_3,
              XIAOYU,
              XIAOYU_2,
              XIAOZHEN,
              XIMENA,
              XIMENA_ES,
              XIMENA_ES_2,
              XIMENA_ES_3,
              YAGO,
              YAN,
              YARA,
              YASHICA,
              YASMIN,
              YESUI,
              YOLANDA,
              YU_JIN,
              YUNDENG,
              YUNFAN,
              YUNFAN_2,
              YUNFENG,
              YUNHAN,
              YUNHAO,
              YUN_JHE,
              YUNJIAN,
              YUNJIE,
              YUN_SONG,
              YUNXI,
              YUNXI_2,
              YUNXIA,
              YUNXIA_2,
              YUNXIANG,
              YUNXIAO,
              YUNXIAO_2,
              YUNYANG,
              YUNYE,
              YUNYE_2,
              YUNYI,
              YUNYI_2,
              YUNZE,
              YUNZHE,
              YVES,
              YVETTE,
              ZARIYAH,
              ZAYD,
              ZEINA,
              ZHIYU,
              ZHIYU_2,
              ZOFIA,
              ZURI));

  private VoiceName(String value) {
    super(value);
  }

  public static Stream<VoiceName> values() {
    return ENUM_SUPPORT.values();
  }

  public static VoiceName from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(VoiceName e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
