package com.yuuta.zardAppNeo.data.dataSource

import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import com.yuuta.zardAppNeo.data.model.Lce
import javax.inject.Inject

class FakeArtistInformationSource
    @Inject constructor()
    : ArtistInformationSourceContract {
    override fun getArtistInformation(): Lce<String> {
        return Lce.Content(
            """
                {
                  "releasedDiscs": [
                    {
                      "id": 1,
                      "name": "Good-bye My Loneliness",
                      "releaseYear": "1991",
                      "releaseMonth": "02",
                      "releaseDate": "10",
                      "indexStr": "1st Single",
                      "discType": "single",
                      "is8cm": true,
                      "image": "_1991_02_10_1stsingle.jpg",
                      "trackList": [
                        {
                          "trackName": "Good-bye My Loneliness",
                          "lyrics": "坂井泉水",
                          "composition": "織田哲郎",
                          "arrangement": "明石昌夫",
                          "year": "1991"
                        },
                        {
                          "trackName": "愛は暗闇の中で",
                          "lyrics": "坂井泉水",
                          "composition": "栗林誠一郎",
                          "arrangement": "ZARD・寺尾広",
                          "year": "1991"
                        }
                      ]
                    },
                    {
                      "id": 2,
                      "name": "Good-bye My Loneliness",
                      "releaseYear": "1991",
                      "releaseMonth": "03",
                      "releaseDate": "27",
                      "indexStr": "1st Album",
                      "discType": "album",
                      "is8cm": false,
                      "image": "_1991_03_27_1stalbum.jpg",
                      "trackList": [
                        {
                          "trackName": "Good-bye My Loneliness",
                          "lyrics": "坂井泉水",
                          "composition": "織田哲郎",
                          "arrangement": "明石昌夫",
                          "year": "1991"
                        },
                        {
                          "trackName": "愛は暗闇の中で",
                          "lyrics": "坂井泉水",
                          "composition": "栗林誠一郎",
                          "arrangement": "ZARD・寺尾広",
                          "year": "1991"
                        },
                        {
                          "trackName": "恋女の憂鬱",
                          "lyrics": "川島だりあ",
                          "composition": "川島だりあ",
                          "arrangement": "明石昌夫",
                          "year": "1991"
                        },
                        {
                          "trackName": "Oh! Sugar Baby",
                          "lyrics": "坂井泉水",
                          "composition": "栗林誠一郎",
                          "arrangement": "葉山たけし",
                          "year": "1991"
                        },
                        {
                          "trackName": "女でいたい",
                          "lyrics": "川島だりあ",
                          "composition": "川島だりあ",
                          "arrangement": "葉山たけし",
                          "year": "1991"
                        },
                        {
                          "trackName": "It’s a Boy",
                          "lyrics": "坂井泉水",
                          "composition": "栗林誠一郎",
                          "arrangement": "明石昌夫",
                          "year": "1991"
                        }
                      ]
                    },
                    {
                      "id": 3,
                      "name": "不思議ね…",
                      "releaseYear": "1991",
                      "releaseMonth": "06",
                      "releaseDate": "25",
                      "indexStr": "2nd Single",
                      "discType": "single",
                      "is8cm": true,
                      "image": "_1991_06_25_2ndsingle.jpg",
                      "trackList": [
                        {
                          "trackName": "不思議ね…",
                          "lyrics": "坂井泉水",
                          "composition": "織田哲郎",
                          "arrangement": "明石昌夫",
                          "year": "1991"
                        },
                        {
                          "trackName": "素直に言えなくて",
                          "lyrics": "坂井泉水",
                          "composition": "坂井泉水",
                          "arrangement": "明石昌夫",
                          "year": "1991"
                        }
                      ]
                    }
                  ],
                  "artistName": "ZARD",
                  "debutYear": "1991",
                  "debutMonth": "2",
                  "debutDate": "10"
                }
            """
        )
    }
}
