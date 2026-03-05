//Del 3:
//Komposition (has-a)
//Hvor bruges komposition i din SP1-kode?
//
//I Hero-klasse bruges komposition med arrayet tasker:
//
//Klasserne: Hero og String[] (som repræsenterer inventory/items)
//
//Relationen: En Hero har en samling af tasker/items. Heroen ejer disse items,
// og hvis Heroen fjernes, fjernes items også.
//
//Dette er komposition fordi taskerne er en integreret
// del af Hero-objektet og ikke kan eksistere uafhængigt.
//
//Nedarving (is-a)
//Kunne nogle klasser arve fra en fælles superklasse?
//
//Superklasse: Character 

//Subklasser der kunne arve:
//Hero 
//Enemy 
//NPC 

//Fælles felter i superklassen:
//String navn
//int health
//int maxHealth
//boolean erILive()

//Fælles metoder:
//tagSkade()
//heal()
//visStatus()

//Fordele:
//Undgår at gentage kode
//Nemmere at tilføje nye typer karakterer


//     Del 1
//        ┌─────────────┐
//        │   Building  │
//        │─────────────│
//        │ - name      │
//        │ - rooms     │
//        │─────────────│
//        │ + addRoom() │
//        │ + print()   │
//        └─────────────┘
//              │1
//              │has-a (komposition)
//              │*
//        ┌─────▼─────┐
//        │   Room    │
//        │───────────│
//        │ - name    │
//        │ - lamps   │
//        │ - windows │
//        │───────────│
//        │ + add()   │
//        └───────────┘
//         │1       │1
//         │has-a   │has-a
//         │*       │*
//    ┌────▼───┐ ┌──▼──────┐
//    │  Lamp  │ │ Window  │
//    │────────│ │─────────│
//    │ - watt │ │ - w, h  │
//    └────────┘ │ - area()│
//               └─────────┘
// Del 2
//         ┌─────────┐
//         │ Animal  │  <─── abstrakt (is-a)
//         │─────────│
//         │ - name  │
//         │ - energy│
//         │─────────│
//         │ +attack()│
//         └─────────┘
//              ▲
//              │is-a (nedarving)
//      ┌───────┼───────┐
//      │       │       │
//┌─────┴───┐ ┌─┴────┐ ┌┴──────┐
//│  Lion   │ │ Wolf │ │Rabbit │
//│─────────│ │──────│ │───────│
//│attack:15│ │random│ │attack:3│
//└─────────┘ └──────┘ └───────┘
//
//         ┌─────────┐
//         │ Contest │
//         │─────────│
//         │ - a1    │───────┐
//         │ - a2    │───────┤has-a
//         │ - rounds│       │(association)
//         │─────────│       │
//         │playRound│       │
//         │getWinner│       │
//         └─────────┘       │
//              │            │
//              │uses        │
//              ▼            ▼
//           ┌─────────────────┐
//           │     Animal      │
//           └─────────────────┘

// 2. Fordel ved Building.getTotalLampCount() vs at tælle i main
//Fordele ved at have metoden i Building-klassen:
//
//Indkapsling: Bygningen selv ved bedst, hvordan den skal tælle sine lamper.
// Main skal ikke kende til interne detaljer.
//
//Genbrugelighed: Hvis du skal tælle lamper flere steder i programmet,
// kan du bare kalde metoden.
//
//Vedligeholdelse: Hvis strukturen ændrer sig (fx hvis rum får under-rum),
//skal du kun ændre koden ét sted (i Building-klassen)
//i stedet for alle steder hvor du tæller i main.
//
//3. Hvornår ville det give mening at gøre Animal abstrakt?
//Det giver mening at gøre Animal abstrakt hvis:
//
//Der aldrig skal laves instanser af Animal direkte - kun af subklasser som Lion, Wolf, Rabbit.
//
//attack()-metoden bør være abstrakt, fordi:
//
//Hvert dyr har sin egen måde at angribe på
//
//Der er ingen standard måde at angribe på i den generelle Animal-klasse
//
//Det tvinger subklasser til at implementere deres egen attack-metode
