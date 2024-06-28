import { Box, Typography } from '@mui/material';
import React from 'react'

const Station = ({line, name}) => {
    const color = (line)=> {
        if (line === 'Red') return 'red';
        if (line === 'Blue')    return 'blue';
        if (line === 'Yellow')    return 'yellow';
        if (line === 'Rapid')    return 'aliceblue';
        if (line === 'Aqua')    return 'aqua';
        if (line === 'Violet')    return 'violet';
        if (line === 'Magenta')    return 'magenta';
        if (line === 'Gray')    return 'gray';
        if (line === 'Pink')  return 'pink';
        if (line === 'AirportExpress')  return 'orange';
        if (line === 'Green') return 'green';
     }
  return (
    <Box width='70%' height='10vh' sx={{display:'flex', justifyContent:'space-around', alignItems:'center', borderLeft:`3px solid ${color(line)}`, borderBottom:`3px solid ${color(line)}`}}>
        {/* <Box height='20px' width='20px' borderRadius='50%' backgroundColor={color(line)}></Box> */}
        <Box sx={{ width:'80%', display:'flex', justifyContent:'left', alignItems:'center'}}> <Typography>{name}</Typography> </Box>
    </Box>
  )
}

export default Station