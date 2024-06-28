import { Avatar, Box, IconButton, Typography } from '@mui/material';
import logo from '../logo1.png';
import React from 'react'

const Header = () => {
  return (
    <Box zIndex='2' position='fixed' top='0' maxWidth='xl' sx={{ height:'10vh', width:"100vw", display:'flex', backgroundColor:'#039be5', alignItems:'center', marginBottom:'15vh'}}>
        <Box sx={{width:{xs:'20%', md:"30%", lg:'10%'}, height:'100%', display:'flex', alignItems:'center', paddingLeft:'2vw'}}>
            <IconButton sx={{ p: 0 }}>
                <Avatar alt="logo" src={logo} sx={{ objectFit:'contain'}}/>
            </IconButton>
        </Box>

        <Box sx={{width:{xs:'80%', md:"70%", lg:'90%'}, height:'100%', textAlign:'center'}}>
            <Typography height='100%' fontFamily={"fantasy"} fontSize="1.5rem" sx={{color:'white', display:'flex', alignItems:'center', justifyContent:'center'}}>
                Delhi Metro
            </Typography>
        </Box>
    </Box>
  )
}

export default Header