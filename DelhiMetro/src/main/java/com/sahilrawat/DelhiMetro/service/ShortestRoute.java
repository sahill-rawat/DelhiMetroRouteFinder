package com.sahilrawat.DelhiMetro.service;

import java.util.*;
class Pair{
    int node;
    int distance;
    public Pair(int distance, int node){
        this.node = node;
        this.distance = distance;
    }
}
public class ShortestRoute {

    static private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static private int n;

    static void init() {

        adj = new ArrayList<>();
        n = 288;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // red line
        adj.get(1).addAll(List.of(2));
        adj.get(2).addAll(List.of(1, 3));
        adj.get(3).addAll(List.of(2, 4));
        adj.get(4).addAll(List.of(3, 5));
        adj.get(5).addAll(List.of(4, 6));
        adj.get(6).addAll(List.of(5, 7));
        adj.get(7).addAll(List.of(6, 8));
        adj.get(8).addAll(List.of(7, 9));
        adj.get(9).addAll(List.of(8, 10));
        adj.get(10).addAll(List.of(9, 11));
        adj.get(11).addAll(List.of(10, 12));
        adj.get(12).addAll(List.of(11, 13));
        adj.get(13).addAll(List.of(12, 14, 245, 247));
        adj.get(14).addAll(List.of(13, 15));
        adj.get(15).addAll(List.of(14, 16));
        adj.get(16).addAll(List.of(15, 17, 40, 42, 156)); //kg
        adj.get(17).addAll(List.of(16, 18));
        adj.get(18).addAll(List.of(17, 19));
        adj.get(19).addAll(List.of(18, 20));
        adj.get(20).addAll(List.of(19, 21));
        adj.get(21).addAll(List.of(20, 22, 124)); // 260
        adj.get(22).addAll(List.of(21, 23));
        adj.get(23).addAll(List.of(22, 24));

        adj.get(24).addAll(List.of(23, 25, 216, 218));

        adj.get(25).addAll(List.of(24, 26));

        adj.get(26).addAll(List.of(25, 27, 245, 247));
        adj.get(27).addAll(List.of(26, 28));
        adj.get(28).addAll(List.of(27, 29));
        adj.get(29).addAll(List.of(28));

        // yellow line
        adj.get(30).addAll(List.of(31));
        adj.get(31).addAll(List.of(30, 32));
        adj.get(32).addAll(List.of(31, 33));
        adj.get(33).addAll(List.of(32, 34));
        adj.get(34).addAll(List.of(33, 35));
        adj.get(35).addAll(List.of(34, 36, 214, 216));
        adj.get(36).addAll(List.of(35, 37));
        adj.get(37).addAll(List.of(36, 38));
        adj.get(38).addAll(List.of(37, 39));
        adj.get(39).addAll(List.of(38, 40));
        adj.get(40).addAll(List.of(39, 41));
        adj.get(41).addAll(List.of(40, 42, 156, 15, 17)); // kG
        adj.get(42).addAll(List.of(41, 43, 245, 247));
        adj.get(43).addAll(List.of(42, 44));
        adj.get(44).addAll(List.of(43, 45, 118));
        adj.get(45).addAll(List.of(44, 46, 94, 96));
        adj.get(46).addAll(List.of(45, 47));
        adj.get(47).addAll(List.of(46, 48, 161, 163));
        adj.get(48).addAll(List.of(47, 49));
        adj.get(49).addAll(List.of(48, 50));

        adj.get(50).addAll(List.of(49, 51)); // 260

        adj.get(51).addAll(List.of(50, 52, 228, 230));

        adj.get(52).addAll(List.of(51, 53));

        adj.get(53).addAll(List.of(52, 54));

        adj.get(54).addAll(List.of(53, 55, 199, 201));

        adj.get(55).addAll(List.of(54, 56));

        adj.get(56).addAll(List.of(55, 57));
        adj.get(57).addAll(List.of(56, 58));
        adj.get(58).addAll(List.of(57, 59));
        adj.get(59).addAll(List.of(58, 60));
        adj.get(60).addAll(List.of(59, 61));

        adj.get(61).addAll(List.of(60, 62));

        adj.get(62).addAll(List.of(61, 63));

        adj.get(63).addAll(List.of(62, 64, 148, 150));

        adj.get(64).addAll(List.of(63, 65));
        adj.get(65).addAll(List.of(64, 66));
        adj.get(66).addAll(List.of(65));

        //blue line 285
        int index = 67;
        adj.get(67).addAll(List.of(68, 287, 121));
        adj.get(68).addAll(List.of(67, 69));
        adj.get(69).addAll(List.of(68, 70));
        adj.get(70).addAll(List.of(69, 71));
        adj.get(71).addAll(List.of(70, 72));
        adj.get(72).addAll(List.of(71, 73));
        adj.get(73).addAll(List.of(72, 74));
        adj.get(74).addAll(List.of(73, 75));
        adj.get(75).addAll(List.of(74, 76, 285)); // 75
        adj.get(76).addAll(List.of(75, 77));
        adj.get(77).addAll(List.of(76, 78));
        adj.get(78).addAll(List.of(77, 79));
        adj.get(79).addAll(List.of(78, 80));
        adj.get(80).addAll(List.of(79, 81, 169)); // 80
        adj.get(81).addAll(List.of(80, 82));
        adj.get(82).addAll(List.of(81, 83));
        adj.get(83).addAll(List.of(82, 84));
        adj.get(84).addAll(List.of(83, 85));

        adj.get(85).addAll(List.of(220, 222, 84, 86)); //85

        adj.get(86).addAll(List.of(85, 87));
        adj.get(87).addAll(List.of(86, 88));
        adj.get(88).addAll(List.of(87, 89, 240)); //88
        adj.get(89).addAll(List.of(88, 90));
        adj.get(90).addAll(List.of(89, 91));
        adj.get(91).addAll(List.of(90, 92));
        adj.get(92).addAll(List.of(91, 93));
        adj.get(93).addAll(List.of(92, 94));
        adj.get(94).addAll(List.of(93, 95));
        adj.get(95).addAll(List.of(94, 96, 44, 46)); //95
        adj.get(96).addAll(List.of(95, 97));
        adj.get(97).addAll(List.of(96, 98, 159, 161)); //97
        adj.get(98).addAll(List.of(97, 99));
        adj.get(99).addAll(List.of(98, 100));
        adj.get(100).addAll(List.of(99, 101, 253)); //100
        adj.get(101).addAll(List.of(100, 102));
        adj.get(102).addAll(List.of(101, 103, 234, 236)); //102
        adj.get(103).addAll(List.of(102, 104));
        adj.get(104).addAll(List.of(103, 105));
        adj.get(105).addAll(List.of(104, 106));
        adj.get(106).addAll(List.of(105, 107));
        adj.get(107).addAll(List.of(106, 108));
        adj.get(108).addAll(List.of(107, 109, 212)); //108
        adj.get(109).addAll(List.of(108, 110));
        adj.get(110).addAll(List.of(109, 111));
        adj.get(111).addAll(List.of(110, 112));
        adj.get(112).addAll(List.of(111, 113));
        adj.get(113).addAll(List.of(112, 114));
        adj.get(114).addAll(List.of(113, 115));
        adj.get(115).addAll(List.of(114, 116));
        adj.get(116).addAll(List.of(115));

//        index = 117;
        //airport-express
        adj.get(117).addAll(List.of(43, 45, 118));
        adj.get(118).addAll(List.of(117, 119));
        adj.get(119).addAll(List.of(118, 120));
        adj.get(120).addAll(List.of(119, 121));
        adj.get(121).addAll(List.of(120, 122));
        adj.get(122).addAll(List.of(121, 287));
        adj.get(287).addAll(List.of(122));

        //green
        adj.get(123).addAll(List.of(20, 22, 124));
        adj.get(124).addAll(List.of(123, 261, 125));
        adj.get(125).addAll(List.of(124, 288));
        adj.get(288).addAll(List.of(218, 220, 125, 126));
        adj.get(126).addAll(List.of(288, 127));
        adj.get(127).addAll(List.of(126, 128));
        adj.get(128).addAll(List.of(127, 129));
        adj.get(129).addAll(List.of(128, 130));
        adj.get(130).addAll(List.of(129, 131));
        adj.get(131).addAll(List.of(130, 132));
        adj.get(132).addAll(List.of(131, 133));
        adj.get(133).addAll(List.of(132, 134));
        adj.get(134).addAll(List.of(133, 135));
        adj.get(135).addAll(List.of(134, 136));
        adj.get(136).addAll(List.of(135, 137));
        adj.get(137).addAll(List.of(136, 138));
        adj.get(138).addAll(List.of(137, 139));
        adj.get(139).addAll(List.of(138, 140));
        adj.get(140).addAll(List.of(139, 141));
        adj.get(141).addAll(List.of(140, 142));
        adj.get(142).addAll(List.of(141, 143));
        adj.get(143).addAll(List.of(142));
        adj.get(260).addAll(List.of(123, 261, 125));
        adj.get(261).addAll(List.of(260, 262));
        adj.get(262).addAll(List.of(261, 87, 89));

        //rapid
        adj.get(144).addAll(List.of(145));
        adj.get(145).addAll(List.of(144, 146));
        adj.get(146).addAll(List.of(145, 147));
        adj.get(147).addAll(List.of(146, 148));
        adj.get(148).addAll(List.of(147, 149));
        adj.get(149).addAll(List.of(148, 150, 62, 64));
        adj.get(150).addAll(List.of(149, 151));
        adj.get(151).addAll(List.of(152));
        adj.get(152).addAll(List.of(153));
        adj.get(153).addAll(List.of(154));
        adj.get(154).addAll(List.of(150));

        //violet
        adj.get(155).addAll(List.of(15, 17, 40, 42, 156));
        adj.get(156).addAll(List.of(155, 157));
        adj.get(157).addAll(List.of(156, 158));
        adj.get(158).addAll(List.of(157, 159));
        adj.get(159).addAll(List.of(158, 160));
        adj.get(160).addAll(List.of(159, 161, 96, 98));
        adj.get(161).addAll(List.of(160, 162));
        adj.get(162).addAll(List.of(161, 163, 46, 48));
        adj.get(163).addAll(List.of(162, 164));
        adj.get(164).addAll(List.of(163, 165));
        adj.get(165).addAll(List.of(164, 166));
        adj.get(166).addAll(List.of(165, 167, 230, 232));

        adj.get(167).addAll(List.of(166, 168));
        adj.get(168).addAll(List.of(167, 169));
        adj.get(169).addAll(List.of(168, 170));
        adj.get(170).addAll(List.of(169, 171));
        adj.get(171).addAll(List.of(170, 172));

        adj.get(172).addAll(List.of(171, 173));
        adj.get(173).addAll(List.of(172, 174));
        adj.get(174).addAll(List.of(173, 175));
        adj.get(175).addAll(List.of(174, 176));
        adj.get(176).addAll(List.of(175, 177));
        adj.get(177).addAll(List.of(176, 178));
        adj.get(178).addAll(List.of(177, 179));
        adj.get(179).addAll(List.of(178, 180));
        adj.get(180).addAll(List.of(179, 181));
        adj.get(181).addAll(List.of(180, 182));
        adj.get(182).addAll(List.of(181, 183));
        adj.get(183).addAll(List.of(182, 184));
        adj.get(184).addAll(List.of(183, 185));
        adj.get(185).addAll(List.of(184, 186));
        adj.get(186).addAll(List.of(185, 187));
        adj.get(187).addAll(List.of(186, 188));
        adj.get(188).addAll(List.of(187));

        //magenta line
        adj.get(189).addAll(List.of(79, 81, 190));
        adj.get(190).addAll(List.of(189, 191));
        adj.get(191).addAll(List.of(190, 192));
        adj.get(192).addAll(List.of(191, 193));
        adj.get(193).addAll(List.of(192, 194));
        adj.get(194).addAll(List.of(193, 195));
        adj.get(195).addAll(List.of(194, 196));
        adj.get(196).addAll(List.of(195, 197));
        adj.get(197).addAll(List.of(196, 198));
        adj.get(198).addAll(List.of(197, 199));
        adj.get(199).addAll(List.of(198, 200));

        adj.get(200).addAll(List.of(199, 201, 53, 55)); // hk

        adj.get(201).addAll(List.of(200, 202));
        adj.get(202).addAll(List.of(201, 203));
        adj.get(203).addAll(List.of(202, 204));
        adj.get(204).addAll(List.of(203, 205));
        adj.get(205).addAll(List.of(204, 206, 169, 171));
        adj.get(206).addAll(List.of(205, 207));
        adj.get(207).addAll(List.of(206, 208));
        adj.get(208).addAll(List.of(207, 209));
        adj.get(209).addAll(List.of(208, 210));
        adj.get(210).addAll(List.of(209, 211));
        adj.get(211).addAll(List.of(210, 212));
        adj.get(212).addAll(List.of(211, 213));
        adj.get(213).addAll(List.of(212, 107, 109));

        //pink line
        adj.get(214).addAll(List.of(215));
        adj.get(215).addAll(List.of(214, 36, 34)); // azadpur
        adj.get(216).addAll(List.of(215, 217));
        adj.get(217).addAll(List.of(216, 218, 25, 23));
        adj.get(218).addAll(List.of(217, 219));
        adj.get(219).addAll(List.of(218, 220, 126, 125));
        adj.get(220).addAll(List.of(219, 221));
        adj.get(221).addAll(List.of(220, 222, 84, 86)); //rajouri garden
        adj.get(222).addAll(List.of(221, 223));
        adj.get(223).addAll(List.of(222, 224));
        adj.get(224).addAll(List.of(223, 225)); // hk
        adj.get(225).addAll(List.of(224, 226));
        adj.get(226).addAll(List.of(225, 227));
        adj.get(227).addAll(List.of(226, 228));
        adj.get(228).addAll(List.of(227, 229));
        adj.get(229).addAll(List.of(228, 230, 50, 52));
        adj.get(230).addAll(List.of(229, 231));
        adj.get(231).addAll(List.of(230, 232, 165, 167));
        adj.get(232).addAll(List.of(231, 233));
        adj.get(233).addAll(List.of(232, 234));
        adj.get(234).addAll(List.of(233, 235));
        adj.get(235).addAll(List.of(234, 236, 101, 103));
        adj.get(236).addAll(List.of(235, 237));
        adj.get(237).addAll(List.of(236, 238));
        adj.get(238).addAll(List.of(237, 239));
        adj.get(239).addAll(List.of(238, 240));
        adj.get(240).addAll(List.of(239, 241));
        adj.get(241).addAll(List.of(240, 242, 258));
        adj.get(242).addAll(List.of(241, 243, 255));
        adj.get(243).addAll(List.of(242, 244));
        adj.get(244).addAll(List.of(243, 245));
        adj.get(245).addAll(List.of(244, 246));
        adj.get(246).addAll(List.of(245, 247, 12, 14));
        adj.get(247).addAll(List.of(246, 248));
        adj.get(248).addAll(List.of(247, 249));
        adj.get(249).addAll(List.of(248, 250));
        adj.get(250).addAll(List.of(249, 251));
        adj.get(251).addAll(List.of(250));

        //blue line
        adj.get(252).addAll(List.of(99, 253, 101));
        adj.get(253).addAll(List.of(252, 254));
        adj.get(254).addAll(List.of(253, 255));
        adj.get(255).addAll(List.of(254, 256));
        adj.get(256).addAll(List.of(255, 257, 243, 241));
        adj.get(257).addAll(List.of(256, 258));
        adj.get(258).addAll(List.of(257, 259));
        adj.get(259).addAll(List.of(258));

        // gray
        adj.get(284).addAll(List.of(285, 74, 76));
        adj.get(285).addAll(List.of(286, 284));
        adj.get(286).addAll(List.of(285));
    }

    static ArrayList<Integer> find(int src, int dest) {

        init();
        int[] vis = new int[n+1];
        int[] dist = new int[n+1];
        int[] parent = new int[n + 1];

        Arrays.fill(dist, 1000000);
        Arrays.fill(vis, 0);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((x, y)->x.distance-y.distance);

        q.add(new Pair(0, src));

        while (!q.isEmpty()) {

            int currDist = q.peek().distance;
            int currNode = q.peek().node;
            q.remove();

            for (Integer node : adj.get(currNode)) {
                if (currDist+1 < dist[node]) {
                    dist[node] = currDist+1;
                    q.add(new Pair(currDist+1, node));
                    parent[node] = currNode;
                }
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        getPath(path, parent, dest);
        return path;
    }
    static void getPath(ArrayList<Integer> path, int[] parent, int node) {

        if (parent[node] == -1) {
            path.add(node);
            return;
        }
        getPath(path, parent, parent[node]);
        path.add(node);
    }
}
