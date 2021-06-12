items = (
"beer",
"wurstdarm",
"weisswurst",
"weisswurstroh",
"breze",
"brezenteig",
"brezemitsalz",
"versalzenebrezemitsalz",
"butterbreze",
"butterbrezemitsalz",
"salz",
"semmel",
"semmelteig",
"wurstroh",
"wurstgekocht",
"wurstgebraten",
"currywurst",
"currywurstmitpommes",
"pommesroh",
"pommes",
"pommesmitsalz",
"versalzenepommesmitsalz",
"leberkas",
"leberkasroh",
"semmelknodel",
"semmelknodelteig",
"braten",
"bratenroh",
"schweinebraten",
"mehl",
"hackbratenroh",
"hackbraten",
"schweinehackfleisch",
"hahnchenhackfleisch",
"rinderhackfleisch",
"hahnchenpattyroh",
"rinderpattyroh",
"schweinepattyroh",
"hahnchenpatty",
"rinderpatty",
"schweinepatty",
"schweineburger",
"hahnchenburger",
"rinderburger",
"kartoffelsalat",
"tomate",
"salat",
"zwiebel",
"zwiebelgeschnitten",
"lowenzahn",
"pfanne",
"messer",
"teigroller",
"kochloffel",
"sense",
"fackel",
"mistgabel",
"filzhut",
"hemd",
"lederhose",
"schuh"
)

"""
{
  "parent": "item/generated",
  "textures": {
    "layer0": "tutorial:item/fabric_item"
  }
}
"""

for item in items:
    f = open(item + ".json", "w")
    f.write('{\n\t"parent":"item/generated",\n\t"textures": {\n\t\t"layer0": "bayernmod:item/' + item + '"\n\t}\n}')
    f.close()
