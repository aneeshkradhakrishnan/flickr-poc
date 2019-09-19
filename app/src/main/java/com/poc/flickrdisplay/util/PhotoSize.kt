package com.poc.flickrdisplay.util

enum class PhotoSize(val value: String) {

    S("s"), //	small square 75x75
    Q("q"), //	large square 150x150
    T("t"), //	thumbnail, 100 on longest side
    M("m"), //	small, 240 on longest side
    N("n"), //	small, 320 on longest side
    L("-"), //	medium, 500 on longest side
    Z("z"), //	medium 640, 640 on longest side
    C("c"), //	medium 800, 800 on longest side†
    B("b"), //	large, 1024 on longest side*
    H("h"), //	large 1600, 1600 on longest side†
    K("k"), //	large 2048, 2048 on longest side†
    O("o"), //	original image, either a jpg, gif or png, depending on source format
}