package com.example.myapplication

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color


import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import kotlinx.coroutines.delay


private const val TAG = "MoreScreenContainer"


@Preview(showBackground = true, device = Devices.DEFAULT, showSystemUi = true)
@Composable
fun PreviewUserProfileScreen() {
    ScreenContainer()
}



@Composable
fun ScreenContainer(){


    val name = remember { mutableStateOf("ahmed") }



    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar( title = { UserProfileHeader(name.value.capitalize().toString()) },
                modifier = Modifier.height(83.sdp),
                backgroundColor = Color.White,
                elevation = 0.sdp)
        }
        ,bottomBar = {
            NavigationBar (modifier = Modifier
                .height(85.sdp)
                //.padding(bottom = 10.sdp)
                .border(
                    width = 1.sdp, color = colorResource(id = R.color.tint_color),
                    shape = RoundedCornerShape(8.sdp)
                ),
                containerColor = Color.White,
                tonalElevation = 0.sdp,
                ){

                BottomNavigationBar()
            }
        }) { innerPadding ->

        Design(modifier = Modifier.padding(innerPadding))


    }

}

@Composable
fun Design(modifier: Modifier){

    Box (modifier = modifier){
        UserProfileScreen()
    }
}


@Composable
fun UserProfileScreen() {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 16.sdp, top = 10.sdp, end = 10.sdp, bottom = 0.sdp)
            ,
        ) {

            ActionButtons()
            Spacer(modifier = Modifier.height(0.sdp))
            MyAccountSection()
            Spacer(modifier = Modifier.height(14.sdp))
            LinksSection()

        }

}


@Composable
fun UserProfileHeader(name : String) {



    Row(modifier = Modifier
        .fillMaxWidth()
        .height(75.sdp)
        .padding(top = 33.sdp))
    {

        Box (modifier = Modifier.weight(1f)){


            val firstLetter = name.first().toString()

            ImageButton(
                shape = CircleShape,
                color = colorResource(id = R.color.char_name),
                sizeBtn = 40,
                image = null,
                des = "Edit Button",
                sizeImage = 30,
                fontSize = 17,
                text = firstLetter,
                textColor = colorResource(id = R.color.blue_new_design),
                onClickAction = {}
            )
        }



        Spacer(modifier = Modifier.width(4.sdp))


        Box (modifier = Modifier.weight(4f)){


            Column {
                Text(
                    text = "Hi, good day",
                    fontSize = 19.ssp,
                    color =  colorResource(id = R.color.black_new_design)
                    , fontFamily = FontFamily(Font(R.font.lama_sans_semi_bold))
                )


                Spacer(modifier = Modifier.height(4.sdp))

                val name_first16Chars = name.take(16)

                Text(
                    text = name_first16Chars,
                    fontSize = 19.ssp,
                    color =  colorResource(id = R.color.black_new_design)
                    , fontFamily = FontFamily(Font(R.font.lama_sans_semi_bold))
                )
            }


        }


        Spacer(modifier = Modifier.width(16.sdp))


        Box (modifier = Modifier.weight(1f), contentAlignment = Alignment.Center){
            ImageButton(
                shape = RectangleShape,
                color = Color.Transparent,
                sizeBtn = 37,
                image = R.drawable.edit,
                des = "Edit Button",
                sizeImage = 70,
                fontSize = 12,
                text = null,
                textColor = Color.White,
                onClickAction = {

                    Log.d(TAG, "UserProfileHeader: edit")

                }
            )
        }


    }
}





@Composable
fun ImageButton(
    shape: Shape,
    color: Color,
    sizeBtn: Int,
    image: Int?,
    des: String,
    sizeImage: Int,
    fontSize: Int,
    text: String?,
    textColor: Color,
    onClickAction: () -> Unit
) {

    val elevation = if (color == Color.Transparent || color == null) ButtonDefaults.elevation(defaultElevation = 0.sdp, pressedElevation = 0.sdp) else ButtonDefaults.elevation(defaultElevation = 4.sdp, pressedElevation = 8.sdp)

    Button(
        onClick = onClickAction,
        shape = shape,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        elevation = elevation,
        modifier = Modifier.size(sizeBtn.sdp),

    ) {

        if(image == null && text != null){
            Text(text = text, fontSize = fontSize.ssp,
                color = textColor, fontFamily = FontFamily(Font(R.font.lama_sans_semi_bold)) )
        } else if(image != null && text == null){
            Image(
                painter = painterResource(id = image),
                contentDescription = des,
                modifier = Modifier.size(sizeImage.sdp)

            )
        }





    }
}


/////0000000000

@Composable
fun VerticalDesign(image: Int?,
                   des: String,
                   sizeImage: Int,
                   fontSize: Int,
                   text: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(60.sdp)
            .clip(RoundedCornerShape(8.sdp))
            .background(color = colorResource(id = R.color.btn_color))
    ) {
        Column (modifier = Modifier

            .fillMaxWidth()
           // .padding(5.sdp)

        
        ){

            Image(
                painter = painterResource(id = image!!),
                contentDescription = des,
                modifier = Modifier
                    .size(sizeImage.sdp)
                    .align(Alignment.CenterHorizontally)

            )

            Spacer(modifier = Modifier.height(5.sdp))

            Text(text = text!!,
                fontSize = fontSize.ssp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = colorResource(id = R.color.blue_new_design)
                , fontFamily = FontFamily(Font(R.font.lama_sans_semi_bold))

            )


        }


    }

}



@Composable
fun ActionButtons() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 0.sdp, bottom = 10.sdp)) {


        Box(modifier = Modifier
            .weight(1f)
            .clickable(onClick = {
                Log.d(TAG, "ActionButtons: Orders")

            })) {
            VerticalDesign(
                image = R.drawable.receipt_long,
                des = "Orders",
                sizeImage = 21,
                fontSize = 11,
                text = "Orders"
            )
        }

        Spacer(modifier = Modifier
            .width(5.sdp)
            .weight(0.1f))

        Box(modifier = Modifier
            .weight(1f)
            .clickable(onClick = {
                Log.d(TAG, "ActionButtons: Rewards")

            })) {

            VerticalDesign(
                image = R.drawable.featured_seasonal_and_gifts,
                des = "Rewards",
                sizeImage = 21,
                fontSize = 11,
                text = "Rewards"
            )
        }

        Spacer(modifier = Modifier
            .width(5.sdp)
            .weight(0.1f))

        Box(modifier = Modifier
            .weight(1f)
            .clickable(onClick = {
                Log.d(TAG, "ActionButtons: Wish lists")
            })) {


            VerticalDesign(
                image = R.drawable.favorite,
                des = "Wish lists",
                sizeImage = 19,
                fontSize = 11,
                text = "Wish lists"
            )

        }

        Spacer(modifier = Modifier
            .width(5.sdp)
            .weight(0.1f))

        Box(modifier = Modifier
            .weight(1f)
            .clickable(onClick = {
                Log.d(TAG, "ActionButtons: Compare")

            })) {
            VerticalDesign(
                image = R.drawable.compare_arrows,
                des = "Compare",
                sizeImage = 21,
                fontSize = 11,
                text = "Compare"
            )

        }
    }
}

@Composable
fun MyAccountSection() {




    Column (modifier = Modifier
        .fillMaxWidth()
        .height(175.sdp)
        .padding(start = 0.sdp)
        .border(
            width = 1.sdp, color = colorResource(id = R.color.tint_color),
            shape = RoundedCornerShape(8.sdp)
        )){

        Spacer(modifier = Modifier.height(9.sdp))




        Box  (modifier = Modifier
            .fillMaxWidth()
            .height(26.sdp)
            .padding(start = 11.sdp, top = 5.sdp)){

            Text(text = "My account", fontSize = 14.ssp,color = colorResource(id = R.color.blue_new_design)
                , fontFamily = FontFamily(Font(R.font.lama_sans_semi_bold)))

        }

        Spacer(modifier = Modifier.height(1.sdp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.sdp, end = 12.sdp)
            .background(colorResource(id = R.color.tint_color))
            .height(1.sdp))

        Spacer(modifier = Modifier.height(5.sdp))

        ListItem(text = "Addresses", R.drawable.address, onClickAction = {
            Log.d(TAG, "MyAccountSection: Addresses")
        })

        Spacer(modifier = Modifier.height(5.sdp))

        ListItem(text = "Wallet", R.drawable.wallet, onClickAction = {
            Log.d(TAG, "MyAccountSection: Wallet")
        })

        Spacer(modifier = Modifier.height(5.sdp))

        ListItem(text = "Notifications", R.drawable.notifications, onClickAction = {
            Log.d(TAG, "MyAccountSection: Notifications")
        })

        Spacer(modifier = Modifier.height(5.sdp))

        ListItem(text = "Language", R.drawable.language,  onClickAction = {
            Log.d(TAG, "MyAccountSection: Language")
        })
    }
}

@Composable
fun LinksSection() {
    Column (modifier = Modifier
        .fillMaxWidth()
        .height(209.sdp)
        .border(
            width = 1.sdp, color = colorResource(id = R.color.tint_color),
            shape = RoundedCornerShape(8.sdp)
        )){

        Spacer(modifier = Modifier.height(13.sdp))

        Box  (modifier = Modifier
            .fillMaxWidth()
            .height(22.sdp)
            .padding(start = 12.sdp)){

            Text(text = "Links", fontSize = 14.ssp,
                color = colorResource(id = R.color.blue_new_design),
                fontFamily = FontFamily(Font(R.font.lama_sans_semi_bold)))

        }

        Spacer(modifier = Modifier.height(1.sdp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.sdp, end = 12.sdp)
            .background(colorResource(id = R.color.tint_color))
            .height(1.sdp))

        Spacer(modifier = Modifier.height(4.sdp))
        //Text(text = "Links", fontSize = 18.ssp, fontWeight = FontWeight.Bold)
        ListItem(text = "Contact us", R.drawable.contact_us, onClickAction = {
            Log.d(TAG, "LinksSection: Contact us")
        })

        Spacer(modifier = Modifier.height(4.sdp))

        ListItem(text = "Branches", R.drawable.branches, onClickAction = {
            Log.d(TAG, "LinksSection: Branches")
        })

        Spacer(modifier = Modifier.height(4.sdp))


        ListItem(text = "Return & refund", R.drawable.return_refund, onClickAction = {
            Log.d(TAG, "LinksSection: Return & refund")
        })

        Spacer(modifier = Modifier.height(4.sdp))


        ListItem(text = "Terms & conditions", R.drawable.terms_conditions, onClickAction = {
            Log.d(TAG, "LinksSection: Terms & conditions")
        })

        Spacer(modifier = Modifier.height(4.sdp))


        ListItem(text = "Static page", R.drawable.static_page, onClickAction = {
            Log.d(TAG, "LinksSection: Static page")
        })

    }
}

@Composable
fun ListItem(text: String, image: Int,
             onClickAction: () -> Unit) {
    Row(modifier = Modifier
        .padding(start = 13.sdp)
        .fillMaxWidth()
        .height(29.sdp)
        .clickable(onClick = onClickAction)) {



       // Spacer(modifier = Modifier.height(30.sdp))


            Image(
                painter = painterResource(id = image),
                contentDescription = "des",
                modifier = Modifier
                    .size(10.sdp)
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(5.sdp))

            Text(text = text,
                fontSize = 12.ssp,
                modifier = Modifier.align(Alignment.CenterVertically),
                color = colorResource(id = R.color.black_new_design)
                , fontFamily = FontFamily(Font(R.font.lama_sans_semi_bold))
            )




       /* Text(text = text, modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)*/
    }
}







@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White,
        elevation = 0.sdp
    ) {
        Spacer(modifier = Modifier.width(1.sdp))

        BottomBarItem(image = R.drawable.home, txt = "Home", onClick = {
            Log.d("BottomNavigationBar", "home")
        })

        BottomBarItem(image = R.drawable.widgets, txt = "Categories", onClick = {
            Log.d("BottomNavigationBar", "Categories")
        })

        BottomBarItem(image = R.drawable.sell, txt = "Deals", onClick = {
            Log.d("BottomNavigationBar", "Deals")
        })

        BottomBarItem(image = R.drawable.menu, txt = "More", onClick = {
            Log.d("BottomNavigationBar", "More")
        })

        Spacer(modifier = Modifier.width(1.sdp))
    }
}

@Composable
fun BottomBarItem(image: Int, txt: String, onClick: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    var isPressed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .size(55.sdp)
            .background(Color.Transparent)
            .clickable(onClick = {
                onClick()
                isVisible = true
                isPressed = true
            },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(1.sdp))
        IconWithFlash(image = image, txt = txt, isVisible = isVisible, isPressed = isPressed, onVisibilityChanged = {
            isVisible = it
            isPressed = false
        })
        Text(
            text = txt,
            fontSize = 9.ssp,
            color = if (isPressed) colorResource(id = R.color.blue_new_design) else colorResource(id = R.color.black_new_design),
            fontFamily = FontFamily(Font(R.font.lama_sans_semi_bold))
        )
        Spacer(modifier = Modifier.height(1.sdp))
    }
}

@Composable
fun IconWithFlash(image: Int, txt: String, isVisible: Boolean, isPressed: Boolean, onVisibilityChanged: (Boolean) -> Unit) {
    LaunchedEffect(isVisible) {
        if (isVisible) {
            delay(200)
            onVisibilityChanged(false)
        }
    }

    Box(
        modifier = Modifier
            .width(40.sdp)
            .height(24.sdp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.sdp))
                    .background(Color.Gray)
            )
        }

        Icon(
            painter = painterResource(id = image),
            contentDescription = txt,
            modifier = Modifier.size(16.sdp),
            tint = if (isPressed) colorResource(id = R.color.blue_new_design) else colorResource(id = R.color.black_new_design)
        )
    }
}




